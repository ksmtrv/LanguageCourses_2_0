package ru.vsu.cs.languagecourses_2_0.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.languagecourses_2_0.entity.Intensity;
import ru.vsu.cs.languagecourses_2_0.repository.IntensityRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
public class IntensityController {
    private final IntensityRepository intensityRepository;

    public IntensityController(IntensityRepository intensityRepository) {
        this.intensityRepository = intensityRepository;
    }

    @GetMapping("/intensity")
    public ResponseEntity<List<Intensity>> getIntensity() {
        List<Intensity> result = new ArrayList<Intensity>();
        intensityRepository.findAll().forEach(result::add);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/intensity/{id}")
    public ResponseEntity<Intensity> getIntensityById(@PathVariable("id") Long id) {
        Intensity intensity = intensityRepository.findById(id);

        if (intensity != null) {
            return new ResponseEntity<>(intensity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/intensity")
    public ResponseEntity<String> createIntensity(@RequestBody Intensity intensity) {
        try {
            intensityRepository.save(new Intensity(intensity.getName()));
            return new ResponseEntity<>("Intensity was created successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/intensity/{id}")
    public ResponseEntity<String> updateIntensity(@PathVariable("id") Long id, @RequestBody Intensity rIntensity) {
        Intensity intensity = intensityRepository.findById(id);

        if (intensity != null) {
            intensity.setId(id);
            intensity.setName(rIntensity.getName());

            intensityRepository.update(intensity);
            return new ResponseEntity<>("Intensity was updated successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cannot find intensity with id=" + id, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/intensity/{id}")
    public ResponseEntity<String> deleteIntensity(@PathVariable("id") long id) {
        try {
            intensityRepository.deleteById(id);
            return new ResponseEntity<>("Intensity was deleted successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Cannot delete intensity.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
