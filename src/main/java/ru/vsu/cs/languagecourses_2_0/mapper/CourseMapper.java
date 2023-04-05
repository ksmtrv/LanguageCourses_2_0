package ru.vsu.cs.languagecourses_2_0.mapper;

import org.springframework.stereotype.Service;
import ru.vsu.cs.languagecourses_2_0.entity.Course;
import ru.vsu.cs.languagecourses_2_0.entity.dto.CourseDto;

@Service
public class CourseMapper implements Mapper<Course, CourseDto>{

    @Override
    public CourseDto toDTO(Course entity) {
        CourseDto courseDto = new CourseDto();
        courseDto.setPrice(entity.getPrice());
        courseDto.setTitle(entity.getTitle());
        return courseDto;
    }

    @Override
    public Course toEntity(CourseDto dto) {
        Course course = new Course();
        course.setTitle(dto.getTitle());
        course.setPrice(dto.getPrice());
        return course;
    }
}
