package ru.vsu.cs.languagecourses_2_0.repository;

import org.springframework.stereotype.Repository;
import ru.vsu.cs.languagecourses_2_0.entity.Listener;

import java.util.List;

@Repository
public class ListenerRepository implements CrudRepository<Listener>{
    @Override
    public int save(Listener listener) {
        return 0;
    }

    @Override
    public int update(Listener listener) {
        return 0;
    }

    @Override
    public Listener findById(Long id) {
        return null;
    }

    @Override
    public Integer deleteById(Long id) {
        return null;
    }

    @Override
    public List<Listener> findAll() {
        return null;
    }
}
