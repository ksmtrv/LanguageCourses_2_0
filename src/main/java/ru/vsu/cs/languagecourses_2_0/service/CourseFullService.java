package ru.vsu.cs.languagecourses_2_0.service;

import org.springframework.stereotype.Service;
import ru.vsu.cs.languagecourses_2_0.entity.Course;
import ru.vsu.cs.languagecourses_2_0.entity.CourseFull;
import ru.vsu.cs.languagecourses_2_0.entity.dto.CourseDto;
import ru.vsu.cs.languagecourses_2_0.entity.dto.CourseFullDto;
import ru.vsu.cs.languagecourses_2_0.mapper.CourseFullMapper;
import ru.vsu.cs.languagecourses_2_0.mapper.CourseMapper;
import ru.vsu.cs.languagecourses_2_0.repository.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseFullService {
    private final CourseFullRepository repository;
    private final CourseFullMapper mapper;
    private final LanguageRepository languageRepository;
    private final LevelRepository levelRepository;
    private final IntensityRepository intensityRepository;

    public CourseFullService(CourseFullRepository repository,
                             CourseFullMapper mapper,
                             LanguageRepository languageRepository,
                             LevelRepository levelRepository,
                             IntensityRepository intensityRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.languageRepository = languageRepository;
        this.levelRepository = levelRepository;
        this.intensityRepository = intensityRepository;
    }

    public List<CourseFullDto> getAllCourse() {
        return repository.findAll().stream()
                .map(mapper::toDTO).collect(Collectors.toList());
    }

    public void saveNewCourse(CourseFullDto courseFullDto) {
        repository.save(mapper.toEntity(courseFullDto));
    }

    private CourseFull findById(Long id) {
        return repository.findAll().stream()
                .filter(val->val.getId().equals(id)).toList().get(0);
    }


    public CourseFullDto getById(Long id) {
        CourseFull courseFull = repository.findById(id);
        if (courseFull != null) {
            return mapper.toDTO(repository.findById(id));
        } else return null;
    }

    public void deleteCourse(Long id) {
        repository.deleteById(id);
    }

    public void updateCourse(Long id, CourseFullDto courseFullDto) {
        CourseFull oldCourse = findById(id);
        oldCourse.setTitle(courseFullDto.getTitle());
        oldCourse.setPrice(courseFullDto.getPrice());
        oldCourse.setIntensity_id(courseFullDto.getIntensity_id());
        oldCourse.setLanguage_id(courseFullDto.getLanguage_id());
        oldCourse.setLevel_id(courseFullDto.getLevel_id());
        repository.update(oldCourse);
    }
}
