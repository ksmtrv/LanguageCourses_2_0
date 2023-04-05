package ru.vsu.cs.languagecourses_2_0.mapper;

import org.springframework.stereotype.Service;
import ru.vsu.cs.languagecourses_2_0.entity.Course;
import ru.vsu.cs.languagecourses_2_0.entity.dto.CourseDto;

@Service
public class CourseMapper implements Mapper<Course, CourseDto>{

    @Override
    public CourseDto toDTO(Course entity) {
        return null;
    }

    @Override
    public Course toEntity(CourseDto dto) {
        return null;
    }
}
