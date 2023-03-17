//package ru.vsu.cs.languagecourses_2_0.controller;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import ru.vsu.cs.languagecourses_2_0.entity.Listener;
//import ru.vsu.cs.languagecourses_2_0.repository.mb.ListenerRepository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//public class ListenerController {
//    private final ListenerRepository listenerRepository;
//
//    public ListenerController(ListenerRepository listenerRepository) {
//        this.listenerRepository = listenerRepository;
//    }
//
//    @GetMapping("/listeners")
//    public ResponseEntity<List<Listener>> getListeners() {
//        List<Listener> result = new ArrayList<Listener>();
//        listenerRepository.findAll().forEach(result::add);
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }
//
//    @GetMapping("/listeners/{id}")
//    public ResponseEntity<Listener> getListenersById(@PathVariable("id") long id) {
//        Listener listener = listenerRepository.findById(id).orElse(null);
//
//        if (listener != null) {
//            return new ResponseEntity<>(listener, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @PostMapping("/listeners")
//    public ResponseEntity<String> createListener(@RequestBody Listener listener) {
//        try {
//            listenerRepository.save(new Listener(listener.getName(), listener.getSurname(), listener.getEmail()));
//            return new ResponseEntity<>("Listener was created successfully.", HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @PutMapping("/listeners/{id}")
//    public ResponseEntity<String> updateListener(@PathVariable("id") long id, @RequestBody Listener rListener) {
//        Listener listener = listenerRepository.findById(id).orElse(null);
//
//        if (listener != null) {
//            listener.setId(id);
//            listener.setName(rListener.getName());
//            listener.setSurname(rListener.getSurname());
//            listener.setEmail(rListener.getEmail());
//
//            listenerRepository.save(listener);
//            return new ResponseEntity<>("Listener was updated successfully.", HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("Cannot find listener with id=" + id, HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @DeleteMapping("/listeners/{id}")
//    public ResponseEntity<String> deleteListeners(@PathVariable("id") long id) {
//        try {
//            listenerRepository.deleteById(id);
//            return new ResponseEntity<>("Listener was deleted successfully.", HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>("Cannot delete listener.", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//}
