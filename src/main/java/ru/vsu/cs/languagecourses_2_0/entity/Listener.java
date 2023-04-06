package ru.vsu.cs.languagecourses_2_0.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Listener")
public class Listener {
    @Id
    @Column("id")
    private Long id;
    @Column("surname")
    private String surname;
    @Column("name")
    private String name;
    @Column("email")
    private String email;
    @MappedCollection(idColumn = "listener_id", keyColumn = "course_id")
    Set<CourseRef> courses = new HashSet<>();

    public void addCourse(Course course) {
        this.courses.add(new CourseRef(AggregateReference.to(course.getId())));
    }

    public void removeCourse(Course course) {
        this.courses.remove(new CourseRef(AggregateReference.to(course.getId())));
    }

    public void addCourseRef(CourseRef courseRef) {
        this.courses.add(courseRef);
    }
}
