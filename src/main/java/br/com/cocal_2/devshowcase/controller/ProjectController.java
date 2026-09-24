package br.com.cocal_2.devshowcase.controller;

import br.com.cocal_2.devshowcase.dto.FeedbackRequestDTO;
import br.com.cocal_2.devshowcase.dto.ProjectRequestDTO;
import br.com.cocal_2.devshowcase.dto.ProjectResponseDTO;
import br.com.cocal_2.devshowcase.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping
    public ResponseEntity<ProjectResponseDTO> criar(@RequestBody @Valid ProjectRequestDTO dto) {
        ProjectResponseDTO salvo = projectService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping
    public ResponseEntity<Page<ProjectResponseDTO>> buscarTodos(
            @RequestParam(required = false) String technology,
            Pageable pageable) {
        Page<ProjectResponseDTO> projetos = projectService.buscarTodos(technology, pageable);
        return ResponseEntity.ok(projetos);
    }

    @PostMapping("/{id}/feedbacks")
    public ResponseEntity<ProjectResponseDTO> adicionarFeedback(
            @PathVariable Long id,
            @RequestBody @Valid FeedbackRequestDTO dto) {
        ProjectResponseDTO response = projectService.adicionarFeedback(id, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}/upvote")
    public ResponseEntity<ProjectResponseDTO> upvote(@PathVariable Long id) {
        ProjectResponseDTO response = projectService.upvote(id);
        return ResponseEntity.ok(response);
    }
}
