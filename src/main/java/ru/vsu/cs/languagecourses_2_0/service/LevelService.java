package ru.vsu.cs.languagecourses_2_0.service;

import org.springframework.stereotype.Service;
import ru.vsu.cs.languagecourses_2_0.entity.Level;
import ru.vsu.cs.languagecourses_2_0.entity.dto.IntensityDto;
import ru.vsu.cs.languagecourses_2_0.entity.dto.LevelDto;
import ru.vsu.cs.languagecourses_2_0.mapper.LevelMapper;
import ru.vsu.cs.languagecourses_2_0.repository.LevelRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LevelService {
    private final LevelRepository repository;
    private final LevelMapper mapper;

    public LevelService(LevelRepository repository, LevelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<LevelDto> getAllLevels() {
        return repository.findAll().stream()
                .map(mapper::toDTO).collect(Collectors.toList());
    }

    public void saveNewLevel(LevelDto levelDto) {
        repository.save(mapper.toEntity(levelDto));
    }

    private Level findById(Long id) {
        return repository.findAll().stream()
                .filter(val -> val.getId().equals(id)).toList().get(0);
    }

    public LevelDto getById(Long id) {
        Level level = repository.findById(id);
        if (level != null) {
            return mapper.toDTO(repository.findById(id));
        } else return null;
    }

    public void deleteLevel(Long id) {
        repository.deleteById(id);
    }

    public void updateLevel(Long id, LevelDto levelDto) {
        Level oldLevel = findById(id);
        oldLevel.setName(levelDto.getName());
        repository.update(oldLevel);
    }
}
