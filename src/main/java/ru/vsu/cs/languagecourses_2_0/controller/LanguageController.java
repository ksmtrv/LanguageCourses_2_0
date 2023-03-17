package ru.vsu.cs.languagecourses_2_0.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.languagecourses_2_0.entity.dto.LanguageDto;
import ru.vsu.cs.languagecourses_2_0.service.LanguageService;

import java.util.List;

@RestController
public class LanguageController {
    private final LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/languages")
    public ResponseEntity<List<LanguageDto>> getLanguages() {
        return new ResponseEntity<>(languageService.getAllLanguages(), HttpStatus.OK);
    }

    @GetMapping("/languages/{id}")
    public ResponseEntity<LanguageDto> getLanguageById(@PathVariable("id") long id) {
        LanguageDto languageDto = languageService.getById(id);

        if (languageDto != null) {
            return new ResponseEntity<>(languageDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/languages")
    public ResponseEntity<String> createLanguage(@RequestBody LanguageDto languageDto) {
        try {
            languageService.saveNewLanguage(languageDto);
            return new ResponseEntity<>("Language was created successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/languages/{id}")
    public ResponseEntity<String> updateLanguage(@PathVariable("id") long id, @RequestBody LanguageDto rLanguageDto) {
        LanguageDto languageDto = languageService.getById(id);

        if (languageDto != null) {
            languageService.updateLanguage(id, rLanguageDto);
            return new ResponseEntity<>("Language was updated successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cannot find Language with id=" + id, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/languages/{id}")
    public ResponseEntity<String> deleteLanguage(@PathVariable("id") long id) {
        try {
            languageService.deleteLanguage(id);
            return new ResponseEntity<>("Language was deleted successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Cannot delete language.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}