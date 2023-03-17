package ru.vsu.cs.languagecourses_2_0.entity;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "intensity")
public class Intensity {
    @Id
    @Column("id")
    private Long id;
    @NotNull
    @Column("name")
    private String name;
    @NotNull
    @MappedCollection(keyColumn = "id", idColumn = "intensity_id")
    private Set<Course> courses;

    public Intensity(String name) {
        this.name = name;
    }
}