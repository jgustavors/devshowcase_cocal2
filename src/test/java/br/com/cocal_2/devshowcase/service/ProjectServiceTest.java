package br.com.cocal_2.devshowcase.service;

import br.com.cocal_2.devshowcase.dto.FeedbackRequestDTO;
import br.com.cocal_2.devshowcase.dto.ProjectResponseDTO;
import br.com.cocal_2.devshowcase.model.Project;
import br.com.cocal_2.devshowcase.repository.ProjectRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProjectServiceTest {

    @Mock
    private ProjectRepository projectRepository;

    @InjectMocks
    private ProjectService projectService;

    private Project mockProject;

    @BeforeEach
    void setUp() {
        mockProject = new Project();
        mockProject.setId(1L);
        mockProject.setTitle("Projeto Teste");
        mockProject.setUpvotes(0);
        mockProject.setFeedbacks(new ArrayList<>());
        mockProject.setAverageRating(0.0);
    }

    @Test
    void testUpvote() {
        // Arrange
        when(projectRepository.findById(1L)).thenReturn(Optional.of(mockProject));
        when(projectRepository.save(any(Project.class))).thenReturn(mockProject);

        // Act
        ProjectResponseDTO response = projectService.upvote(1L);

        // Assert
        assertEquals(1, response.getUpvotes(), "O upvote deve ser incrementado para 1");
    }

    @Test
    void testAdicionarFeedbackECalcularMedia() {
        // Arrange
        when(projectRepository.findById(1L)).thenReturn(Optional.of(mockProject));
        when(projectRepository.save(any(Project.class))).thenReturn(mockProject);

        FeedbackRequestDTO feedback1 = new FeedbackRequestDTO();
        feedback1.setAuthor("João");
        feedback1.setComment("Muito bom!");
        feedback1.setRating(5);

        FeedbackRequestDTO feedback2 = new FeedbackRequestDTO();
        feedback2.setAuthor("Maria");
        feedback2.setComment("Poderia melhorar");
        feedback2.setRating(4);

        // Act
        projectService.adicionarFeedback(1L, feedback1);
        ProjectResponseDTO response = projectService.adicionarFeedback(1L, feedback2);

        // Assert
        assertEquals(4.5, response.getAverageRating(), "A média deve ser 4.5 ((5+4)/2)");
    }
}
