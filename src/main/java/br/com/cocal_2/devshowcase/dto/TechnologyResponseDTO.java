package br.com.cocal_2.devshowcase.dto;

import br.com.cocal_2.devshowcase.model.Technology;

public class TechnologyResponseDTO {

    private Long id;
    private String name;
    private String iconUrl;

    public TechnologyResponseDTO() {}

    public TechnologyResponseDTO(Technology technology) {
        this.id = technology.getId();
        this.name = technology.getName();
        this.iconUrl = technology.getIconUrl();
    }

    public static TechnologyResponseDTO fromEntity(Technology technology) {
        return new TechnologyResponseDTO(technology);
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getIconUrl() { return iconUrl; }
    public void setIconUrl(String iconUrl) { this.iconUrl = iconUrl; }
}
