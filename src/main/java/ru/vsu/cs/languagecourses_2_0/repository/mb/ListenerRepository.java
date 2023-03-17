package ru.vsu.cs.languagecourses_2_0.repository.mb;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.languagecourses_2_0.entity.Listener;

@Repository
public interface ListenerRepository extends CrudRepository<Listener, Long> {

}