package ru.vsu.cs.languagecourses_2_0.repository;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.languagecourses_2_0.entity.Course;
import ru.vsu.cs.languagecourses_2_0.entity.CourseFull;

import java.util.List;

@Repository
public class CourseRepository implements CrudRepository<Course> {
    private final JdbcTemplate jdbcTemplate;

    public CourseRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(Course course) {
        return jdbcTemplate.update("INSERT INTO course (title, price) VALUES(?,?)",
                new Object[] {course.getTitle(), course.getPrice()});
    }

    @Override
    public int update(Course course) {
        return jdbcTemplate.update("UPDATE course SET title=?, price=? WHERE id=?",
                new Object[] {course.getTitle(), course.getPrice(), course.getId()});
    }

    @Override
    public Course findById(Long id) {
        try {
            Course course = jdbcTemplate.queryForObject("SELECT * FROM course WHERE id=?",
                    BeanPropertyRowMapper.newInstance(Course.class), id);
            return course;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public Integer deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM course WHERE id=?", id);
    }

    @Override
    public List<Course> findAll() {
        return jdbcTemplate.query("SELECT * from course",
                BeanPropertyRowMapper.newInstance(Course.class));
    }

    public List<CourseFull> findAllFull() {
        return jdbcTemplate.query("SELECT * from course",
                BeanPropertyRowMapper.newInstance(CourseFull.class));
    }
}
