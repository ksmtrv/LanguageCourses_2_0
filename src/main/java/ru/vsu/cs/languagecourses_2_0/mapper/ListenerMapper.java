package ru.vsu.cs.languagecourses_2_0.mapper;

import org.springframework.stereotype.Service;
import ru.vsu.cs.languagecourses_2_0.entity.Listener;
import ru.vsu.cs.languagecourses_2_0.entity.dto.ListenerDto;

@Service
public class ListenerMapper implements Mapper<Listener, ListenerDto>{

    @Override
    public ListenerDto toDTO(Listener entity) {
        ListenerDto listenerDto = new ListenerDto();
        listenerDto.setSurname(entity.getSurname());
        listenerDto.setName(entity.getName());
        listenerDto.setEmail(entity.getEmail());
        return listenerDto;
    }

    @Override
    public Listener toEntity(ListenerDto dto) {
        Listener listener = new Listener();
        listener.setSurname(dto.getSurname());
        listener.setName(dto.getName());
        listener.setEmail(dto.getEmail());
        return listener;
    }
}
