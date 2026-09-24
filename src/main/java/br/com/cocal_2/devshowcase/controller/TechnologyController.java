package br.com.cocal_2.devshowcase.controller;

import br.com.cocal_2.devshowcase.dto.TechnologyRequestDTO;
import br.com.cocal_2.devshowcase.dto.TechnologyResponseDTO;
import br.com.cocal_2.devshowcase.service.TechnologyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technologies")
public class TechnologyController {

    @Autowired
    private TechnologyService service;

    @PostMapping
    public ResponseEntity<TechnologyResponseDTO> criar(@RequestBody @Valid TechnologyRequestDTO dto) {
        TechnologyResponseDTO salvo = service.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping
    public ResponseEntity<List<TechnologyResponseDTO>> buscarTodos() {
        return ResponseEntity.ok(service.buscarTodos());
    }
}