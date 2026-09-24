package br.com.cocal_2.devshowcase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cocal_2.devshowcase.dto.TechnologyResponseDTO;
import br.com.cocal_2.devshowcase.repository.TechnologyRepository;

@Service
public class TechnologyService {

	@Autowired
	private TechnologyRepository repository;
	
	public Technology buscarPorId (Long Id) {
		return this.repository.findById(Id).get();
	}
	
	@Transactional(readOnly = true)
    public List<TechnologyResponseDTO> buscarTodos() {
        return repository.findAll().stream()
                .map(TechnologyResponseDTO::fromEntity)
                .toList();
    }
}