package ru.vsu.cs.languagecourses_2_0.entity;

import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "course_listener")
public class CourseRef {
    AggregateReference<Course, Long> courseId;


}
