package ru.vsu.cs.languagecourses_2_0.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.languagecourses_2_0.entity.dto.IntensityDto;
import ru.vsu.cs.languagecourses_2_0.service.IntensityService;

import java.util.List;

@RestController
public class IntensityController {
    private final IntensityService intensityService;

    public IntensityController(IntensityService intensityService) {
        this.intensityService = intensityService;
    }

    @GetMapping("/intensity")
    public ResponseEntity<List<IntensityDto>> getIntensity() {
        return new ResponseEntity<>(intensityService.getAllIntensity(), HttpStatus.OK);
    }

    @GetMapping("/intensity/{id}")
    public ResponseEntity<IntensityDto> getIntensityById(@PathVariable("id") Long id) {
        IntensityDto intensityDto = intensityService.getById(id);
        if (intensityDto != null) {
            return new ResponseEntity<>(intensityDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/intensity")
    public ResponseEntity<String> createIntensity(@RequestBody IntensityDto intensityDto) {
        try {
            intensityService.saveNewIntensity(intensityDto);
            return new ResponseEntity<>("Intensity was created successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/intensity/{id}")
    public ResponseEntity<String> updateIntensity(@PathVariable("id") Long id, @RequestBody IntensityDto rIntensityDto) {
        IntensityDto intensityDto = intensityService.getById(id);

        if (intensityDto != null) {
            intensityService.updateIntensity(id, rIntensityDto);
            return new ResponseEntity<>("Intensity was updated successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cannot find intensity with id=" + id, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/intensity/{id}")
    public ResponseEntity<String> deleteIntensity(@PathVariable("id") long id) {
        try {
            intensityService.deleteIntensity(id);
            return new ResponseEntity<>("Intensity was deleted successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Cannot delete intensity.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}