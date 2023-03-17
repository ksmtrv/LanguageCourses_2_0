package ru.vsu.cs.languagecourses_2_0.mapper;

import org.springframework.stereotype.Service;
import ru.vsu.cs.languagecourses_2_0.entity.Level;
import ru.vsu.cs.languagecourses_2_0.entity.dto.LevelDto;

@Service
public class LevelMapper implements Mapper<Level, LevelDto> {
    @Override
    public LevelDto toDTO(Level entity) {
        LevelDto levelDto = new LevelDto();
        levelDto.setName(entity.getName());
        return levelDto;
    }

    @Override
    public Level toEntity(LevelDto dto) {
        Level level = new Level();
        level.setName(dto.getName());
        return level;
    }
}