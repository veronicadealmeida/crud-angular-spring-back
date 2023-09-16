package edu.vda.crud.spring.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;


@Data
@Entity(name = "courses")
@SQLDelete(sql = "UPDATE courses SET status = 'Inativo' WHERE id = ?")
@Where(clause = "status = 'Ativo'")
public class Course {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private Long id;

    @NotBlank
    @NotNull
    @Length(min = 5 , max = 100)
    @Column(name = "name", length = 100,nullable = false)
    private String name;

    @NotBlank
    @NotNull
    @Length(max = 10)
    @Pattern(regexp = "back-end|front-end")
    @Column(name = "category", length = 10, nullable = false)
    private String category;

    @NotBlank
    @NotNull
    @Length(max = 10)
    @Pattern(regexp = "Ativo|Inativo")
    @Column(name = "status", length = 10, nullable = false)
    private String status = "Ativo";
}
