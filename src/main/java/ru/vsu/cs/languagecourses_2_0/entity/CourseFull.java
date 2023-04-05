package ru.vsu.cs.languagecourses_2_0.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Course")
public class CourseFull {
    @Id
    @Column("id")
    private Long id;
    @Column("title")
    private String title;
    @Column("price")
    private Integer price;
    @Column("intensity_id")
    private Integer intensity_id;
    @Column("language_id")
    private Integer language_id;
    @Column("level_id")
    private Integer level_id;
}

