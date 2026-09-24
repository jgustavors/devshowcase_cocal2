package br.com.cocal_2.devshowcase.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ProfileRequestDTO {

    @NotBlank(message = "O nome é obrigatório")
    @Size(max = 150, message = "O nome deve ter no máximo 150 caracteres")
    private String name;

    @Size(max = 500, message = "A bio deve ter no máximo 500 caracteres")
    private String bio;

    @Size(max = 100, message = "O usuário do GitHub deve ter no máximo 100 caracteres")
    private String githubUsername;

    @Size(max = 255, message = "A URL do avatar deve ter no máximo 255 caracteres")
    private String avatarUrl;

    @Size(max = 255, message = "A URL do LinkedIn deve ter no máximo 255 caracteres")
    private String linkedinUrl;

    // Getters e Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }
    public String getGithubUsername() { return githubUsername; }
    public void setGithubUsername(String githubUsername) { this.githubUsername = githubUsername; }
    public String getAvatarUrl() { return avatarUrl; }
    public void setAvatarUrl(String avatarUrl) { this.avatarUrl = avatarUrl; }
    public String getLinkedinUrl() { return linkedinUrl; }
    public void setLinkedinUrl(String linkedinUrl) { this.linkedinUrl = linkedinUrl; }
}
