package br.com.cocal_2.devshowcase.dto;

import br.com.cocal_2.devshowcase.model.Profile;

public class ProfileResponseDTO {

    private Long id;
    private String name;
    private String bio;
    private String githubUsername;
    private String avatarUrl;
    private String linkedinUrl;

    public ProfileResponseDTO() {}

    public ProfileResponseDTO(Profile profile) {
        this.id = profile.getId();
        this.name = profile.getName();
        this.bio = profile.getBio();
        this.githubUsername = profile.getGithubUsername();
        this.avatarUrl = profile.getAvatarUrl();
        this.linkedinUrl = profile.getLinkedinUrl();
    }

    public static ProfileResponseDTO fromEntity(Profile profile) {
        return new ProfileResponseDTO(profile);
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
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
