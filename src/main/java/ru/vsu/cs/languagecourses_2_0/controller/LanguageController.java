package ru.vsu.cs.languagecourses_2_0.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.languagecourses_2_0.entity.Language;
import ru.vsu.cs.languagecourses_2_0.repository.LanguageRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LanguageController {
    private final LanguageRepository languageRepository;

    public LanguageController(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @GetMapping("/languages")
    public ResponseEntity<List<Language>> getLanguages() {
        List<Language> result = new ArrayList<Language>();
        languageRepository.findAll().forEach(result::add);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/languages/{id}")
    public ResponseEntity<Language> getLanguageById(@PathVariable("id") long id) {
        Language language = languageRepository.findById(id);

        if (language != null) {
            return new ResponseEntity<>(language, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/languages")
    public ResponseEntity<String> createLanguage(@RequestBody Language language) {
        try {
            languageRepository.save(new Language(language.getName()));
            return new ResponseEntity<>("Language was created successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/languages/{id}")
    public ResponseEntity<String> updateLanguage(@PathVariable("id") long id, @RequestBody Language rLanguage) {
        Language language = languageRepository.findById(id);

        if (language != null) {
            language.setId(id);
            language.setName(rLanguage.getName());

            languageRepository.save(language);
            return new ResponseEntity<>("Language was updated successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cannot find Language with id=" + id, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/languages/{id}")
    public ResponseEntity<String> deleteLanguage(@PathVariable("id") long id) {
        try {
            languageRepository.deleteById(id);
            return new ResponseEntity<>("Language was deleted successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Cannot delete language.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
