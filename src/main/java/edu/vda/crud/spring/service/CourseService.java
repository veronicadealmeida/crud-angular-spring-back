package edu.vda.crud.spring.service;

import edu.vda.crud.spring.exception.RecordNotFindException;
import edu.vda.crud.spring.model.Course;
import edu.vda.crud.spring.repository.CourseRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Validated
@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public  List<Course> list() {
        return courseRepository.findAll();
    }

    public Course findById(@PathVariable @NotNull @Positive Long id){
        return courseRepository.findById(id).orElseThrow(() -> new RecordNotFindException(id));
    }

    public Course create(@Valid Course course){
        return courseRepository.save(course);
    }

    public Course update( @NotNull @Positive Long id,  @Valid Course course){
        return courseRepository.findById(id)
            .map(recordFound -> {
                recordFound.setName(course.getName());
                recordFound.setCategory(course.getCategory());
                return courseRepository.save(recordFound);
            }).orElseThrow(() -> new RecordNotFindException(id));
    }

    public void delete( @NotNull @Positive Long id) {

        courseRepository.delete(courseRepository
                .findById(id)
                .orElseThrow(() -> new RecordNotFindException(id))
            );
    }
}



