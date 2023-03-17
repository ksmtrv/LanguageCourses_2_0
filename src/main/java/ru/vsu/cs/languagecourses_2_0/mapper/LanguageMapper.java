package ru.vsu.cs.languagecourses_2_0.mapper;

import org.springframework.stereotype.Service;
import ru.vsu.cs.languagecourses_2_0.entity.Language;
import ru.vsu.cs.languagecourses_2_0.entity.dto.LanguageDto;

@Service
public class LanguageMapper implements Mapper<Language, LanguageDto> {

    @Override
    public LanguageDto toDTO(Language entity) {
        LanguageDto languageDto = new LanguageDto();
        languageDto.setName(entity.getName());
        return languageDto;
    }

    @Override
    public Language toEntity(LanguageDto dto) {
        Language language = new Language();
        language.setName(dto.getName());
        return language;
    }
}