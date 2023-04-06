package ru.vsu.cs.languagecourses_2_0.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Table;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "course_listener")
public class CourseRef {
    AggregateReference<Course, Long> courseId;

    public CourseRef(Integer courseId) {
        this.courseId = AggregateReference.to(new Long(courseId));

    }

    public CourseRef(AggregateReference<Course, Long> courseId) {
        this.courseId = courseId;
    }

    public Long getId() {
        return courseId.getId();
    }
}
