package ru.vsu.cs.languagecourses_2_0.repository;

import java.util.List;

public interface CrudRepository<T> {
    int save(T t);

    int update(T t);

    T findById(Long id);

    Integer deleteById(Long id);

    List<T> findAll();
}