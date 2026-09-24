package br.com.cocal_2.devshowcase.service;

import br.com.cocal_2.devshowcase.dto.ProjectRequestDTO;
import br.com.cocal_2.devshowcase.dto.ProjectResponseDTO;
import br.com.cocal_2.devshowcase.model.Profile;
import br.com.cocal_2.devshowcase.model.Project;
import br.com.cocal_2.devshowcase.model.Technology;
import br.com.cocal_2.devshowcase.repository.ProfileRepository;
import br.com.cocal_2.devshowcase.repository.ProjectRepository;
import br.com.cocal_2.devshowcase.repository.TechnologyRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private TechnologyRepository technologyRepository;

    @Transactional
    public ProjectResponseDTO criar(ProjectRequestDTO dto) {
        Profile profile = profileRepository.findById(dto.getProfileId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Perfil não encontrado com o ID: " + dto.getProfileId()));

        List<Technology> technologies = technologyRepository.findAllById(dto.getTechnologyIds());

        Project project = new Project();
        project.setTitle(dto.getTitle());
        project.setDescription(dto.getDescription());
        project.setRepositoryUrl(dto.getRepositoryUrl());
        project.setProfile(profile);
        project.setTechnologies(technologies);

        Project saved = projectRepository.save(project);
        return new ProjectResponseDTO(saved);
    }

    @Transactional(readOnly = true)
    public Page<ProjectResponseDTO> buscarTodos(String technology, Pageable pageable) {
        Page<Project> projects;
        if (technology != null && !technology.isBlank()) {
            projects = projectRepository.findByTechnologyName(technology, pageable);
        } else {
            projects = projectRepository.findAll(pageable);
        }
        return projects.map(ProjectResponseDTO::new);
    }
}
