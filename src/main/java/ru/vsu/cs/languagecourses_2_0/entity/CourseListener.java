package ru.vsu.cs.languagecourses_2_0.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@Getter
@Table(name = "course_listener")
public class CourseListener {
    private Long courseId;
}
