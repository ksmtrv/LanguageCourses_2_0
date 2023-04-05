package ru.vsu.cs.languagecourses_2_0.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.languagecourses_2_0.entity.Course;

import java.util.List;

@Repository
public class CourseRepository implements CrudRepository<Course> {
    private final JdbcTemplate jdbcTemplate;

    public CourseRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(Course course) {
        return 0;
    }

    @Override
    public int update(Course course) {
        return 0;
    }

    @Override
    public Course findById(Long id) {
        return null;
    }

    @Override
    public Integer deleteById(Long id) {
        return null;
    }

    @Override
    public List<Course> findAll() {
        return null;
    }
}
