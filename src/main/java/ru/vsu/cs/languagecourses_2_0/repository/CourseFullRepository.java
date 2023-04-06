package ru.vsu.cs.languagecourses_2_0.repository;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.languagecourses_2_0.entity.CourseFull;

import java.util.List;

@Repository
public class CourseFullRepository implements CrudRepository<CourseFull> {
    private final JdbcTemplate jdbcTemplate;

    public CourseFullRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(CourseFull courseFull) {
        return jdbcTemplate.update("INSERT INTO course (title, price, intensity_id, language_id, level_id) VALUES(?,?,?,?,?)",
                new Object[] {courseFull.getTitle(), courseFull.getPrice(),
                        courseFull.getIntensity_id(), courseFull.getLanguage_id(),
                        courseFull.getLevel_id()});
    }

    @Override
    public int update(CourseFull courseFull) {
        return jdbcTemplate.update("UPDATE course SET title=?, price=?, intensity_id=?, language_id=?, level_id=? WHERE id=?",
                new Object[] {courseFull.getTitle(), courseFull.getPrice(),
                        courseFull.getIntensity_id(), courseFull.getLanguage_id(),
                        courseFull.getLevel_id(), courseFull.getId()});
    }

    @Override
    public CourseFull findById(Long id) {
        try {
            CourseFull courseFull = jdbcTemplate.queryForObject("SELECT * FROM course WHERE id=?",
                    BeanPropertyRowMapper.newInstance(CourseFull.class), id);
            return courseFull;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public Integer deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM course WHERE id=?", id);
    }

    @Override
    public List<CourseFull> findAll() {
        return jdbcTemplate.query("SELECT * from course",
                BeanPropertyRowMapper.newInstance(CourseFull.class));
    }
}
