package ru.vsu.cs.languagecourses_2_0.service;

import org.springframework.stereotype.Service;
import ru.vsu.cs.languagecourses_2_0.entity.Language;
import ru.vsu.cs.languagecourses_2_0.entity.dto.IntensityDto;
import ru.vsu.cs.languagecourses_2_0.entity.dto.LanguageDto;
import ru.vsu.cs.languagecourses_2_0.mapper.LanguageMapper;
import ru.vsu.cs.languagecourses_2_0.repository.LanguageRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LanguageService {
    private final LanguageRepository repository;
    private final LanguageMapper mapper;

    public LanguageService(LanguageRepository repository, LanguageMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<LanguageDto> getAllLanguages() {
        return repository.findAll().stream()
                .map(mapper::toDTO).collect(Collectors.toList());
    }

    public void saveNewLanguage(LanguageDto languageDto) {
        repository.save(mapper.toEntity(languageDto));
    }

    public LanguageDto getById(Long id) {
        return mapper.toDTO(repository.findById(id));
    }

    private Language findById(Long id) {
        return repository.findAll().stream()
                .filter(val->val.getId().equals(id)).toList().get(0);
    }

    public void deleteLanguage(Long id) {
        repository.deleteById(id);
    }

    public void updateLanguage(Long id, LanguageDto languageDto) {
        Language oldLanguage = findById(id);
        oldLanguage.setName(languageDto.getName());
        repository.save(oldLanguage);
    }
}
