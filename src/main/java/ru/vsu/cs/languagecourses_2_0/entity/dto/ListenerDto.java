package ru.vsu.cs.languagecourses_2_0.entity.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ListenerDto {
    private String surname;
    private String name;
    private String email;
    private List<Long> courses;

    public void addCourse(Long course) {
        if (courses == null) {
            courses = new ArrayList<>();
        }
        courses.add(course);
    }
}
