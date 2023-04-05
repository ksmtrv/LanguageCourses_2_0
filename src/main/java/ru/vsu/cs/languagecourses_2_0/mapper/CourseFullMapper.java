package ru.vsu.cs.languagecourses_2_0.mapper;

import org.springframework.stereotype.Service;
import ru.vsu.cs.languagecourses_2_0.entity.Course;
import ru.vsu.cs.languagecourses_2_0.entity.CourseFull;
import ru.vsu.cs.languagecourses_2_0.entity.dto.CourseDto;
import ru.vsu.cs.languagecourses_2_0.entity.dto.CourseFullDto;

@Service
public class CourseFullMapper implements Mapper<CourseFull, CourseFullDto>{

    @Override
    public CourseFullDto toDTO(CourseFull entity) {
        CourseFullDto courseFullDto = new CourseFullDto();
        courseFullDto.setPrice(entity.getPrice());
        courseFullDto.setTitle(entity.getTitle());
        courseFullDto.setIntensity_id(entity.getIntensity_id());
        courseFullDto.setLanguage_id(entity.getLanguage_id());
        courseFullDto.setLevel_id(entity.getLevel_id());
        return courseFullDto;
    }

    @Override
    public CourseFull toEntity(CourseFullDto dtoFull) {
        CourseFull courseFull = new CourseFull();
        courseFull.setTitle(dtoFull.getTitle());
        courseFull.setPrice(dtoFull.getPrice());
        courseFull.setIntensity_id(dtoFull.getIntensity_id());
        courseFull.setLanguage_id(dtoFull.getLanguage_id());
        courseFull.setLevel_id(dtoFull.getLevel_id());
        return courseFull;
    }
}