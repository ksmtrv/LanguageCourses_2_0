package ru.vsu.cs.languagecourses_2_0.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.languagecourses_2_0.entity.Course;
import ru.vsu.cs.languagecourses_2_0.repository.mb.CourseRepository;

import java.util.ArrayList;
import java.util.List;


@RestController
public class CourseController {
    private final CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getCourses() {
        List<Course> result = new ArrayList<Course>();
        courseRepository.findAll().forEach(result::add);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable("id") long id) {
        Course course = courseRepository.findById(id).orElse(null);

        if (course != null) {
            return new ResponseEntity<>(course, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/courses")
    public ResponseEntity<String> createCourse(@RequestBody Course course) {
//        try {
            courseRepository.save(new Course(course.getTitle(), course.getPrice()));
            return new ResponseEntity<>("Course was created successfully.", HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
    }

//    @PutMapping("/courses/{id}")
//    public ResponseEntity<String> updateCourse(@PathVariable("id") long id, @RequestBody Course rCourse) {
//        Course course = courseRepository.findById(id).orElse(null);
//
//        if (course != null) {
//            course.setId(id);
//            course.setTitle(rCourse.getTitle());
//            course.setPrice(rCourse.getPrice());
//
//            courseRepository.save(course);
//            return new ResponseEntity<>("Course was updated successfully.", HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("Cannot find course with id=" + id, HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @DeleteMapping("/courses/{id}")
//    public ResponseEntity<String> deleteCourse(@PathVariable("id") long id) {
//        try {
//            courseRepository.deleteById(id);
//            return new ResponseEntity<>("Course was deleted successfully.", HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>("Cannot delete course.", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}
