package ru.vsu.cs.languagecourses_2_0.controller;

import org.springframework.web.bind.annotation.RestController;
import ru.vsu.cs.languagecourses_2_0.service.ListenerService;

@RestController
public class ListenerController {
    private final ListenerService listenerService;

    public ListenerController(ListenerService listenerService) {
        this.listenerService = listenerService;
    }
}
