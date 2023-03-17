package ru.vsu.cs.languagecourses_2_0.service;

import org.springframework.stereotype.Service;
import ru.vsu.cs.languagecourses_2_0.entity.Intensity;
import ru.vsu.cs.languagecourses_2_0.entity.dto.IntensityDto;
import ru.vsu.cs.languagecourses_2_0.mapper.IntensityMapper;
import ru.vsu.cs.languagecourses_2_0.repository.IntensityRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IntensityService {
    private final IntensityRepository repository;
    private final IntensityMapper mapper;

    public IntensityService(IntensityRepository repository, IntensityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<IntensityDto> getAllIntensity() {
        return repository.findAll().stream()
                .map(mapper::toDTO).collect(Collectors.toList());
    }

    public void saveNewIntensity(IntensityDto intensityDto) {
        repository.save(mapper.toEntity(intensityDto));
    }

    private Intensity findById(Long id) {
        return repository.findAll().stream()
                .filter(val->val.getId().equals(id)).toList().get(0);
    }

    public IntensityDto getById(Long id) {
        Intensity intensity = repository.findById(id);
        if (intensity != null) {
            return mapper.toDTO(repository.findById(id));
        } else return null;
    }

    public void deleteIntensity(Long id) {
        repository.deleteById(id);
    }

    public void updateIntensity(Long id, IntensityDto intensityDto) {
        Intensity oldIntensity = findById(id);
        oldIntensity.setName(intensityDto.getName());
        repository.update(oldIntensity);
    }
}
