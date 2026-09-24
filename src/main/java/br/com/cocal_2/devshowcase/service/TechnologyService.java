package br.com.cocal_2.devshowcase.service;

import br.com.cocal_2.devshowcase.dto.TechnologyRequestDTO;
import br.com.cocal_2.devshowcase.dto.TechnologyResponseDTO;
import br.com.cocal_2.devshowcase.model.Technology;
import br.com.cocal_2.devshowcase.repository.TechnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TechnologyService {

    @Autowired
    private TechnologyRepository repository;

    @Transactional
    public TechnologyResponseDTO criar(TechnologyRequestDTO dto) {
        Technology tech = new Technology();
        tech.setName(dto.getName());
        tech.setIconUrl(dto.getIconUrl());

        Technology saved = repository.save(tech);
        return new TechnologyResponseDTO(saved);
    }

    @Transactional(readOnly = true)
    public Technology buscarPorId(Long id) {
        return this.repository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<TechnologyResponseDTO> buscarTodos() {
        return repository.findAll().stream()
                .map(TechnologyResponseDTO::fromEntity)
                .toList();
    }
}