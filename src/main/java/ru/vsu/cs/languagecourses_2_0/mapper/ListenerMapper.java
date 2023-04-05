package ru.vsu.cs.languagecourses_2_0.mapper;

import org.springframework.stereotype.Service;
import ru.vsu.cs.languagecourses_2_0.entity.Listener;
import ru.vsu.cs.languagecourses_2_0.entity.dto.ListenerDto;

@Service
public class ListenerMapper implements Mapper<Listener, ListenerDto>{

    @Override
    public ListenerDto toDTO(Listener entity) {
        return null;
    }

    @Override
    public Listener toEntity(ListenerDto dto) {
        return null;
    }
}
