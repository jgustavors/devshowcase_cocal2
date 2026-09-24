package br.com.cocal_2.devshowcase.model;

import jakarta.persistence.*;

@Entity
@Table(name = "feedbacks")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150)
    private String author;

    @Column(length = 500)
    private String comment;

    @Column(nullable = false)
    private Integer rating;

    // Relacionamento N : 1 com Project
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    public Feedback() {}

    // Getters e Setters
    public Long getId() { return id; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }
    public Integer getRating() { return rating; }
    public void setRating(Integer rating) { this.rating = rating; }
    public Project getProject() { return project; }
    public void setProject(Project project) { this.project = project; }
}
