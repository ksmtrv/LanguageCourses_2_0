package ru.vsu.cs.languagecourses_2_0.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.languagecourses_2_0.entity.Listener;
import ru.vsu.cs.languagecourses_2_0.entity.dto.ListenerDto;
import ru.vsu.cs.languagecourses_2_0.repository.ListenerRepository;
import ru.vsu.cs.languagecourses_2_0.service.ListenerService;

import java.util.List;

@RestController
public class ListenerController {
    private final ListenerService listenerService;

    public ListenerController(ListenerService listenerService) {
        this.listenerService = listenerService;
    }

    @GetMapping("/listeners")
    public ResponseEntity<List<ListenerDto>> getLanguages() {
        return new ResponseEntity<>(listenerService.getAllListener(), HttpStatus.OK);
    }

    @GetMapping("/listeners/{id}")
    public ResponseEntity<ListenerDto> getListenerById(@PathVariable("id") long id) {
        ListenerDto listenerDto = listenerService.getById(id);

        if (listenerDto != null) {
            return new ResponseEntity<>(listenerDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //    @PostMapping("/listeners")
//    public ResponseEntity<String> createListener(@RequestBody ListenerDto listenerDto) {
//        try {
//            listenerService.saveNewListener(listenerDto);
//            return new ResponseEntity<>("Listener was created successfully.", HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @PutMapping("/listeners/{id}")
//    public ResponseEntity<String> updateListeners(@PathVariable("id") long id, @RequestBody ListenerDto rListenerDto) {
//        ListenerDto listenerDto = listenerService.getById(id);
//
//        if (listenerDto != null) {
//            listenerService.updateListener(id, rListenerDto);
//            return new ResponseEntity<>("Listener was updated successfully.", HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("Cannot find Listener with id=" + id, HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @DeleteMapping("/listeners/{id}")
//    public ResponseEntity<String> deleteListener(@PathVariable("id") long id) {
//        try {
//            listenerService.deleteListener(id);
//            return new ResponseEntity<>("Listener was deleted successfully.", HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>("Cannot delete listener.", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}
