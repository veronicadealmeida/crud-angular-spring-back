package edu.vda.crud.spring.controller;

import edu.vda.crud.spring.model.Course;
import edu.vda.crud.spring.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CourseController {


    private final CourseRepository courseRepository;

    @GetMapping
    public List<Course> list() {
        return courseRepository.findAll();
    }

    @Bean
    CommandLineRunner iniDatabase(CourseRepository courseRepository){
        return args -> {
            courseRepository.deleteAll();

            Course c = new Course();
            c.setName("Angular com Spring");
            c.setCategory("front-end");
            courseRepository.save(c);
        };
    }
}
