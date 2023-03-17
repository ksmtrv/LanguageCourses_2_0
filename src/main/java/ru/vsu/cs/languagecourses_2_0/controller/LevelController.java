package ru.vsu.cs.languagecourses_2_0.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.languagecourses_2_0.entity.Level;
import ru.vsu.cs.languagecourses_2_0.repository.LevelRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LevelController {
    private final LevelRepository levelRepository;

    public LevelController(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }

    @GetMapping("/levels")
    public ResponseEntity<List<Level>> getLevels() {
        List<Level> result = new ArrayList<Level>();
        levelRepository.findAll().forEach(result::add);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/levels/{id}")
    public ResponseEntity<Level> getLevelById(@PathVariable("id") long id) {
        Level level = levelRepository.findById(id);

        if (level != null) {
            return new ResponseEntity<>(level, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/levels")
    public ResponseEntity<String> createLevel(@RequestBody Level level) {
        try {
            levelRepository.save(new Level(level.getName()));
            return new ResponseEntity<>("Level was created successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/levels/{id}")
    public ResponseEntity<String> updateLevel(@PathVariable("id") long id, @RequestBody Level rLevel) {
        Level level = levelRepository.findById(id);

        if (level != null) {
            level.setId(id);
            level.setName(rLevel.getName());

            levelRepository.save(level);
            return new ResponseEntity<>("Level was updated successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cannot find Level with id=" + id, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/levels/{id}")
    public ResponseEntity<String> deleteLevel(@PathVariable("id") long id) {
        try {
            levelRepository.deleteById(id);
            return new ResponseEntity<>("Level was deleted successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Cannot delete level.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
