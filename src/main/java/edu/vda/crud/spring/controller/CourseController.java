package edu.vda.crud.spring.controller;

import edu.vda.crud.spring.model.Course;
import edu.vda.crud.spring.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CourseController {


    private final CourseRepository courseRepository;

    @GetMapping
    public @ResponseBody List<Course> list() {
        return courseRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> findById(@PathVariable Long id){
        return courseRepository.findById(id)
                .map(record ->  ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Course create(@RequestBody Course course){

        return courseRepository.save(course);
    }

    @Bean
    CommandLineRunner iniDatabase(CourseRepository courseRepository){
        return args -> {
            courseRepository.deleteAll();

            Course a = new Course();
            a.setName("Angular");
            a.setCategory("front-end");
            courseRepository.save(a);

            Course b = new Course();
            b.setName("Spring");
            b.setCategory("back-end");
            courseRepository.save(b);
        };
    }
}
