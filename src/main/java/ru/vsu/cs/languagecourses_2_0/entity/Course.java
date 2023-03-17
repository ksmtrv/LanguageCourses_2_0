package ru.vsu.cs.languagecourses_2_0.entity;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "course")
public class Course {
    @Id
    @Column("id")
    private Long id;
    @NotNull
    @Column("title")
    private String title;
    @NotNull
    @Column("price")
    private Integer price;

    public Course(String title, Integer price) {
        this.title = title;
        this.price = price;
    }
}