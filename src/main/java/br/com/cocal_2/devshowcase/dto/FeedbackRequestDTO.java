package br.com.cocal_2.devshowcase.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class FeedbackRequestDTO {

    @NotBlank(message = "O autor é obrigatório")
    @Size(max = 150, message = "O autor deve ter no máximo 150 caracteres")
    private String author;

    @NotBlank(message = "O comentário é obrigatório")
    @Size(max = 500, message = "O comentário deve ter no máximo 500 caracteres")
    private String comment;

    @NotNull(message = "A nota é obrigatória")
    @Min(value = 1, message = "A nota mínima é 1")
    @Max(value = 5, message = "A nota máxima é 5")
    private Integer rating;

    // Getters e Setters
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }
    public Integer getRating() { return rating; }
    public void setRating(Integer rating) { this.rating = rating; }
}
