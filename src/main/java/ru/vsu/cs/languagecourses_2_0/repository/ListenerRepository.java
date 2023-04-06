package ru.vsu.cs.languagecourses_2_0.repository;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.languagecourses_2_0.entity.CourseRef;
import ru.vsu.cs.languagecourses_2_0.entity.Language;
import ru.vsu.cs.languagecourses_2_0.entity.Level;
import ru.vsu.cs.languagecourses_2_0.entity.Listener;

import java.util.List;
import java.util.Set;

@Repository
public class ListenerRepository implements CrudRepository<Listener>{
    private JdbcTemplate jdbcTemplate;

    public ListenerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(Listener listener) {
        return 0;
    }

    @Override
    public int update(Listener listener) {
        return 0;
    }

    @Override
    public Listener findById(Long id) {
        try {
            Listener listener = jdbcTemplate.queryForObject("SELECT * FROM listener WHERE id=?",
                    BeanPropertyRowMapper.newInstance(Listener.class), id);
            List<Integer> course_ids = jdbcTemplate.queryForList("SELECT course_id from course_listener WHERE listener_id=? ", Integer.class, id);
            for (Integer course_id : course_ids) {
                assert listener != null;
                listener.addCourseRef(new CourseRef(course_id));
            }
            return listener;

        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public Integer deleteById(Long id) {
        return null;
    }

    @Override
    public List<Listener> findAll() {
        List<Listener> listeners = jdbcTemplate.query("SELECT * from listener ", BeanPropertyRowMapper.newInstance(Listener.class));
        for (Listener listener : listeners) {
            List<Integer> course_ids = jdbcTemplate.queryForList("SELECT course_id from course_listener WHERE listener_id=? ", Integer.class, listener.getId());
            for (Integer course_id : course_ids) {
                assert listener != null;
                listener.addCourseRef(new CourseRef(course_id));
            }
        }
        return listeners;
    }
}
