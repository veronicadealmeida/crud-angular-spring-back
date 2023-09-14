package edu.vda.crud.spring.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity(name = "courses")
public class Course {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private Long id;

    @Column(name = "name", length = 200,nullable = false)
    private String name;

    @Column(name = "category", length = 10, nullable = false)
    private String category;
}
