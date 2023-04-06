package ru.vsu.cs.languagecourses_2_0.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.languagecourses_2_0.entity.dto.CourseFullDto;
import ru.vsu.cs.languagecourses_2_0.service.CourseFullService;

import java.util.List;

@RestController
public class CourseController {
    private final CourseFullService courseService;

    public CourseController(CourseFullService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public ResponseEntity<List<CourseFullDto>> getCourses() {
        return new ResponseEntity<>(courseService.getAllCourse(), HttpStatus.OK);
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable("id") long id) {
        CourseDto courseDto = courseService.getById(id);

        if (courseDto != null) {
            return new ResponseEntity<>(courseDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/courses")
    public ResponseEntity<String> createCourses(@RequestBody CourseFullDto courseFullDto) {
        try {
            courseService.saveNewCourse(courseFullDto);
            return new ResponseEntity<>("Course was created successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/courses/{id}")
    public ResponseEntity<String> updateCourse(@PathVariable("id") long id, @RequestBody CourseFullDto rCourseFullDto) {
        CourseFullDto courseFullDto = courseService.getById(id);

        if (courseFullDto != null) {
            courseService.updateCourse(id, rCourseFullDto);
            return new ResponseEntity<>("Course was updated successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cannot find Course with id=" + id, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable("id") long id) {
        try {
            courseService.deleteCourse(id);
            return new ResponseEntity<>("Course was deleted successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Cannot delete course.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}