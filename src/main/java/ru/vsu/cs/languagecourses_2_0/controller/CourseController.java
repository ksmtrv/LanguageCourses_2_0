package ru.vsu.cs.languagecourses_2_0.controller;

import org.springframework.web.bind.annotation.RestController;
import ru.vsu.cs.languagecourses_2_0.service.CourseService;

@RestController
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
}
