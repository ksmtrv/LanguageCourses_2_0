package ru.vsu.cs.languagecourses_2_0.mapper;

import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.stereotype.Service;
import ru.vsu.cs.languagecourses_2_0.entity.Course;
import ru.vsu.cs.languagecourses_2_0.entity.CourseRef;
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
        if (entity.getCourses() != null) {
            for (CourseRef courseRef : entity.getCourses()) {
                listenerDto.addCourse(courseRef.getId());
            }
        }
        return listenerDto;
    }

    @Override
    public Listener toEntity(ListenerDto dto) {
//        Listener listener = new Listener();
//        listener.setSurname(dto.getSurname());
//        listener.setName(dto.getName());
//        listener.setEmail(dto.getEmail());
//        return listener;
        return null;
    }
}
