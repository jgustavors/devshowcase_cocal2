package br.com.cocal_2.devshowcase.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;

import java.util.List;

public class ProjectRequestDTO {

    @NotBlank(message = "O título do projeto é obrigatório")
    @Size(max = 200, message = "O título deve ter no máximo 200 caracteres")
    private String title;

    @Size(max = 500, message = "A descrição deve ter no máximo 500 caracteres")
    private String description;

    @NotBlank(message = "A URL do repositório é obrigatória")
    @URL(message = "A URL do repositório deve ser uma URL válida")
    private String repositoryUrl;

    @NotNull(message = "O ID do perfil é obrigatório")
    private Long profileId;

    @NotNull(message = "A lista de tecnologias não pode ser nula")
    private List<Long> technologyIds;

    // Getters e Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getRepositoryUrl() { return repositoryUrl; }
    public void setRepositoryUrl(String repositoryUrl) { this.repositoryUrl = repositoryUrl; }
    public Long getProfileId() { return profileId; }
    public void setProfileId(Long profileId) { this.profileId = profileId; }
    public List<Long> getTechnologyIds() { return technologyIds; }
    public void setTechnologyIds(List<Long> technologyIds) { this.technologyIds = technologyIds; }
}
