package ru.vsu.cs.languagecourses_2_0.mapper;

public interface Mapper<T, D> {
    D toDTO(T entity);
    T toEntity(D dto);
}