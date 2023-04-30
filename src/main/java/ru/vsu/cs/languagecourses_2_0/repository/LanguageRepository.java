package ru.vsu.cs.languagecourses_2_0.repository;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.languagecourses_2_0.entity.Language;

import java.util.List;

@Repository
public class LanguageRepository implements CrudRepository<Language>{
    private JdbcTemplate jdbcTemplate;

    public LanguageRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(Language language) {
        return jdbcTemplate.update("INSERT INTO language (name) VALUES(?)",
                new Object[] {language.getName()});
    }

    @Override
    public int update(Language language) {
        return jdbcTemplate.update("UPDATE language SET name=?  WHERE id=?",
                new Object[] {language.getName(), language.getId()});
    }

    @Override
    public Language findById(Long id) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM language WHERE id=?",
                    BeanPropertyRowMapper.newInstance(Language.class), id);
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public Integer deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM language WHERE id=?", id);

    }

    @Override
    public List<Language> findAll() {
        return jdbcTemplate.query("SELECT * from language ", BeanPropertyRowMapper.newInstance(Language.class));
    }
}