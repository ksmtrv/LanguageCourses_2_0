package ru.vsu.cs.languagecourses_2_0.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.languagecourses_2_0.entity.dto.LevelDto;
import ru.vsu.cs.languagecourses_2_0.service.LevelService;

import java.util.List;

@RestController
public class LevelController {
    private final LevelService levelService;

    public LevelController(LevelService levelService) {
        this.levelService = levelService;
    }

    @GetMapping("/levels")
    public ResponseEntity<List<LevelDto>> getLevels() {
        return new ResponseEntity<>(levelService.getAllLevels(), HttpStatus.OK);
    }

    @GetMapping("/levels/{id}")
    public ResponseEntity<LevelDto> getLevelById(@PathVariable("id") long id) {
        LevelDto levelDto = levelService.getById(id);

        if (levelDto != null) {
            return new ResponseEntity<>(levelDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/levels")
    public ResponseEntity<String> createLevel(@RequestBody LevelDto levelDto) {
        try {
            levelService.saveNewLevel(levelDto);
            return new ResponseEntity<>("Level was created successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/levels/{id}")
    public ResponseEntity<String> updateLevel(@PathVariable("id") long id, @RequestBody LevelDto rLevelDto) {
        LevelDto levelDto = levelService.getById(id);

        if (levelDto != null) {
            levelService.updateLevel(id, rLevelDto);
            return new ResponseEntity<>("Level was updated successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cannot find Level with id=" + id, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/levels/{id}")
    public ResponseEntity<String> deleteLevel(@PathVariable("id") long id) {
        try {
            levelService.deleteLevel(id);
            return new ResponseEntity<>("Level was deleted successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Cannot delete level.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}