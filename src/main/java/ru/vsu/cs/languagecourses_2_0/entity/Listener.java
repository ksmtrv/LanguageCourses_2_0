package ru.vsu.cs.languagecourses_2_0.entity;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;


import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Table(name = "listener")
public class Listener {
    @Id
    @Column("id")
    private Long id;
    @NotNull
    @Column("name")
    private String name;
    @NotNull
    @Column("surname")
    private String surname;
    @NotNull
    @Column("email")
    private String email;
    @NotNull
    @MappedCollection(idColumn = "listener_id")
    private Set<CourseListener> courseListeners = new HashSet<>();

    public Listener(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
}
