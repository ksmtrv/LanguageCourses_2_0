package ru.vsu.cs.languagecourses_2_0.service;

import org.springframework.stereotype.Service;
import ru.vsu.cs.languagecourses_2_0.mapper.ListenerMapper;
import ru.vsu.cs.languagecourses_2_0.repository.ListenerRepository;

@Service
public class ListenerService {
    private final ListenerRepository repository;
    private final ListenerMapper mapper;

    public ListenerService(ListenerRepository repository, ListenerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
}
