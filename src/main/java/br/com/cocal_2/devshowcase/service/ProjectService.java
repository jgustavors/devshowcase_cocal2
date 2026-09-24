package br.com.cocal_2.devshowcase.service;

import br.com.cocal_2.devshowcase.dto.FeedbackRequestDTO;
import br.com.cocal_2.devshowcase.dto.ProjectRequestDTO;
import br.com.cocal_2.devshowcase.dto.ProjectResponseDTO;
import br.com.cocal_2.devshowcase.model.Feedback;
import br.com.cocal_2.devshowcase.model.Profile;
import br.com.cocal_2.devshowcase.model.Project;
import br.com.cocal_2.devshowcase.model.Technology;
import br.com.cocal_2.devshowcase.repository.ProfileRepository;
import br.com.cocal_2.devshowcase.repository.ProjectRepository;
import br.com.cocal_2.devshowcase.repository.TechnologyRepository;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectService {

    private static final Logger log = LoggerFactory.getLogger(ProjectService.class);

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private TechnologyRepository technologyRepository;

    @Transactional
    public ProjectResponseDTO criar(ProjectRequestDTO dto) {
        log.info("Iniciando a criação de um novo projeto: {}", dto.getTitle());
        
        Profile profile = profileRepository.findById(dto.getProfileId())
                .orElseThrow(() -> {
                    log.error("Falha ao criar projeto. Perfil não encontrado com o ID: {}", dto.getProfileId());
                    return new EntityNotFoundException("Perfil não encontrado com o ID: " + dto.getProfileId());
                });

        List<Technology> technologies = technologyRepository.findAllById(dto.getTechnologyIds());
        log.debug("Tecnologias encontradas para o projeto: {}", technologies.size());

        Project project = new Project();
        project.setTitle(dto.getTitle());
        project.setDescription(dto.getDescription());
        project.setRepositoryUrl(dto.getRepositoryUrl());
        project.setProfile(profile);
        project.setTechnologies(technologies);

        Project saved = projectRepository.save(project);
        log.info("Projeto criado com sucesso. ID gerado: {}", saved.getId());
        return new ProjectResponseDTO(saved);
    }

    @Transactional(readOnly = true)
    public Page<ProjectResponseDTO> buscarTodos(String technology, Pageable pageable) {
        log.info("Buscando projetos. Filtro de tecnologia: {}, Paginação: {}", technology, pageable);
        Page<Project> projects;
        if (technology != null && !technology.isBlank()) {
            projects = projectRepository.findByTechnologyName(technology, pageable);
        } else {
            projects = projectRepository.findAll(pageable);
        }
        return projects.map(ProjectResponseDTO::new);
    }

    @Transactional
    public ProjectResponseDTO adicionarFeedback(Long projectId, FeedbackRequestDTO dto) {
        log.info("Adicionando feedback ao projeto ID: {}", projectId);
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> {
                    log.error("Falha ao adicionar feedback. Projeto não encontrado com o ID: {}", projectId);
                    return new EntityNotFoundException("Projeto não encontrado com o ID: " + projectId);
                });

        Feedback feedback = new Feedback();
        feedback.setAuthor(dto.getAuthor());
        feedback.setComment(dto.getComment());
        feedback.setRating(dto.getRating());
        feedback.setProject(project);

        project.getFeedbacks().add(feedback);

        double media = project.getFeedbacks().stream()
                .mapToInt(Feedback::getRating)
                .average()
                .orElse(0.0);

        project.setAverageRating(Math.round(media * 10.0) / 10.0);
        log.debug("Nova média do projeto ID {}: {}", projectId, project.getAverageRating());

        Project saved = projectRepository.save(project);
        log.info("Feedback adicionado com sucesso ao projeto ID: {}", projectId);
        return new ProjectResponseDTO(saved);
    }

    @Transactional
    public ProjectResponseDTO upvote(Long projectId) {
        log.info("Adicionando upvote ao projeto ID: {}", projectId);
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> {
                    log.error("Falha no upvote. Projeto não encontrado com o ID: {}", projectId);
                    return new EntityNotFoundException("Projeto não encontrado com o ID: " + projectId);
                });

        project.setUpvotes(project.getUpvotes() + 1);

        Project saved = projectRepository.save(project);
        log.info("Upvote computado. Projeto ID {} agora tem {} upvotes.", projectId, saved.getUpvotes());
        return new ProjectResponseDTO(saved);
    }
}
