package ru.vsu.cs.languagecourses_2_0.repository;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.languagecourses_2_0.entity.Intensity;

import java.util.List;

@Repository
public class IntensityRepository implements CrudRepository<Intensity>{
    private JdbcTemplate jdbcTemplate;

    public IntensityRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(Intensity intensity) {
        return jdbcTemplate.update("INSERT INTO intensity (name) VALUES(?)",
                new Object[] {intensity.getName()});
    }

    @Override
    public int update(Intensity intensity) {
        return jdbcTemplate.update("UPDATE intensity SET name=?  WHERE id=?",
                new Object[] {intensity.getName(), intensity.getId()});
    }

    @Override
    public Intensity findById(Long id) {
        try {
            Intensity intensity = jdbcTemplate.queryForObject("SELECT * FROM intensity WHERE id=?",
                    BeanPropertyRowMapper.newInstance(Intensity.class), id);
            return intensity;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public Integer deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM intensity WHERE id=?", id);
    }

    @Override
    public List<Intensity> findAll() {
        return jdbcTemplate.query("SELECT * from intensity", BeanPropertyRowMapper.newInstance(Intensity.class));
    }
}