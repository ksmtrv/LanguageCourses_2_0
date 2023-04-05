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

    public List<CourseDto> getAllCourse() {
        return repository.findAll().stream()
                .map(mapper::toDTO).collect(Collectors.toList());
    }

    public void saveNewCourse(CourseDto courseDto) {
        repository.save(mapper.toEntity(courseDto));
    }

    private Course findById(Long id) {
        return repository.findAll().stream()
                .filter(val->val.getId().equals(id)).toList().get(0);
    }

    public CourseDto getById(Long id) {
        Course course = repository.findById(id);
        if (course != null) {
            return mapper.toDTO(repository.findById(id));
        } else return null;
    }

    public void deleteCourse(Long id) {
        repository.deleteById(id);
    }

    public void updateCourse(Long id, CourseDto courseDto) {
        Course oldCourse = findById(id);
        oldCourse.setTitle(courseDto.getTitle());
        oldCourse.setPrice(courseDto.getPrice());
        repository.update(oldCourse);
    }
}
