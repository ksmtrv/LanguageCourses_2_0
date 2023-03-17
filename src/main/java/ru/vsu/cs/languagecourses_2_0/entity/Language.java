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
@Data
@Table(name = "language")
public class Language {
    @Id
    @Column("id")
    private Long id;
    @NotNull
    @Column("name")
    private String name;
}