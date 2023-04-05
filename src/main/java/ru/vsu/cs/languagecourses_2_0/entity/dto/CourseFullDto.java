package ru.vsu.cs.languagecourses_2_0.entity.dto;

import lombok.Data;

@Data
public class CourseFullDto  {
        private String title;
        private Integer price;
        private Integer intensity_id;
        private Integer language_id;
        private Integer level_id;
}
