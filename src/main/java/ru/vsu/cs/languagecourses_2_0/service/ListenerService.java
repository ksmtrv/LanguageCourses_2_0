package ru.vsu.cs.languagecourses_2_0.service;

import org.springframework.stereotype.Service;
import ru.vsu.cs.languagecourses_2_0.entity.Listener;
import ru.vsu.cs.languagecourses_2_0.entity.dto.ListenerDto;
import ru.vsu.cs.languagecourses_2_0.mapper.ListenerMapper;
import ru.vsu.cs.languagecourses_2_0.repository.ListenerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListenerService {
    private final ListenerRepository repository;
    private final ListenerMapper mapper;

    public ListenerService(ListenerRepository repository, ListenerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<ListenerDto> getAllListener() {
        return repository.findAll().stream()
                .map(mapper::toDTO).collect(Collectors.toList());
    }

    public void saveNewListener(ListenerDto listenerDto) {
        repository.save(mapper.toEntity(listenerDto));
    }

    private Listener findById(Long id) {
        return repository.findAll().stream()
                .filter(val->val.getId().equals(id)).toList().get(0);
    }

    public ListenerDto getById(Long id) {
        Listener listener = repository.findById(id);
        if (listener != null) {
            return mapper.toDTO(repository.findById(id));
        } else return null;
    }

    public void deleteListener(Long id) {
        repository.deleteById(id);
    }

    public void updateListener(Long id, ListenerDto listenerDto) {
        Listener oldListener = findById(id);
        oldListener.setSurname(listenerDto.getSurname());
        oldListener.setName(listenerDto.getName());
        oldListener.setEmail(listenerDto.getEmail());
        repository.update(oldListener);
    }
}
