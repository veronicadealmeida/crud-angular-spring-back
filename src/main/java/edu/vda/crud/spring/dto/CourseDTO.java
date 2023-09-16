package edu.vda.crud.spring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public record CourseDTO(
        @JsonProperty("_id")
        Long id,

        @NotBlank
        @NotNull
        @Length(min = 5 , max = 100)
        String name,

        @NotBlank
        @NotNull
        @Length(max = 10)
        @Pattern(regexp = "back-end|front-end")
        String category) {


}
