package ru.vsu.cs.languagecourses_2_0.mapper;

import org.springframework.stereotype.Service;
import ru.vsu.cs.languagecourses_2_0.entity.Intensity;
import ru.vsu.cs.languagecourses_2_0.entity.dto.IntensityDto;

@Service
public class IntensityMapper implements Mapper<Intensity, IntensityDto>{

    @Override
    public IntensityDto toDTO(Intensity entity) {
        IntensityDto intensityDto = new IntensityDto();
        intensityDto.setName(entity.getName());
        return intensityDto;
    }

    @Override
    public Intensity toEntity(IntensityDto dto) {
        Intensity intensity = new Intensity();
        intensity.setName(dto.getName());
        return intensity;
    }
}