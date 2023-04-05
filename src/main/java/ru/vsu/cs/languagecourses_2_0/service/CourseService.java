package ru.vsu.cs.languagecourses_2_0.service;

import org.springframework.stereotype.Service;
import ru.vsu.cs.languagecourses_2_0.mapper.CourseMapper;
import ru.vsu.cs.languagecourses_2_0.repository.CourseRepository;

@Service
public class CourseService {
    private final CourseRepository repository;
    private final CourseMapper mapper;

    public CourseService(CourseRepository repository, CourseMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

}
