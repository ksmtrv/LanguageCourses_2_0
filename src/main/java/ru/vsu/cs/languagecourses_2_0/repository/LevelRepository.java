package ru.vsu.cs.languagecourses_2_0.repository;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.languagecourses_2_0.entity.Language;
import ru.vsu.cs.languagecourses_2_0.entity.Level;

import java.util.List;

@Repository
public class LevelRepository implements CrudRepository<Level>{
    private JdbcTemplate jdbcTemplate;

    public LevelRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(Level level) {
        return jdbcTemplate.update("INSERT INTO level (name) VALUES(?)",
                new Object[] {level.getName()});
    }

    @Override
    public int update(Level level) {
        return jdbcTemplate.update("UPDATE level SET name=?  WHERE id=?",
                new Object[] {level.getName(), level.getId()});
    }

    @Override
    public Level findById(Long id) {
        try {
            Level level = jdbcTemplate.queryForObject("SELECT * FROM level WHERE id=?",
                    BeanPropertyRowMapper.newInstance(Level.class), id);
            return level;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public Integer deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM level WHERE id=?", id);
    }

    @Override
    public List<Level> findAll() {
        return jdbcTemplate.query("SELECT * from level ", BeanPropertyRowMapper.newInstance(Level.class));
    }
}
