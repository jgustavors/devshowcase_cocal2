package br.com.cocal_2.devshowcase.dto;

import br.com.cocal_2.devshowcase.model.Project;

import java.util.List;
import java.util.stream.Collectors;

public class ProjectResponseDTO {

    private Long id;
    private String title;
    private String description;
    private String repositoryUrl;
    private Double averageRating;
    private Integer upvotes;
    private ProfileResponseDTO profile;
    private List<TechnologyResponseDTO> technologies;
    private List<FeedbackResponseDTO> feedbacks;

    public ProjectResponseDTO() {}

    public ProjectResponseDTO(Project project) {
        this.id = project.getId();
        this.title = project.getTitle();
        this.description = project.getDescription();
        this.repositoryUrl = project.getRepositoryUrl();
        this.averageRating = project.getAverageRating();
        this.upvotes = project.getUpvotes();

        if (project.getProfile() != null) {
            this.profile = new ProfileResponseDTO(project.getProfile());
        }
        if (project.getTechnologies() != null) {
            this.technologies = project.getTechnologies().stream()
                    .map(TechnologyResponseDTO::new)
                    .collect(Collectors.toList());
        }
        if (project.getFeedbacks() != null) {
            this.feedbacks = project.getFeedbacks().stream()
                    .map(FeedbackResponseDTO::new)
                    .collect(Collectors.toList());
        }
    }

    public static ProjectResponseDTO fromEntity(Project project) {
        return new ProjectResponseDTO(project);
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getRepositoryUrl() { return repositoryUrl; }
    public void setRepositoryUrl(String repositoryUrl) { this.repositoryUrl = repositoryUrl; }
    public Double getAverageRating() { return averageRating; }
    public void setAverageRating(Double averageRating) { this.averageRating = averageRating; }
    public Integer getUpvotes() { return upvotes; }
    public void setUpvotes(Integer upvotes) { this.upvotes = upvotes; }
    public ProfileResponseDTO getProfile() { return profile; }
    public void setProfile(ProfileResponseDTO profile) { this.profile = profile; }
    public List<TechnologyResponseDTO> getTechnologies() { return technologies; }
    public void setTechnologies(List<TechnologyResponseDTO> technologies) { this.technologies = technologies; }
    public List<FeedbackResponseDTO> getFeedbacks() { return feedbacks; }
    public void setFeedbacks(List<FeedbackResponseDTO> feedbacks) { this.feedbacks = feedbacks; }
}
