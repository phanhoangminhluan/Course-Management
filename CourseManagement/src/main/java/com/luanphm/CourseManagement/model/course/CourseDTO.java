package com.luanphm.CourseManagement.model.course;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.luanphm.CourseManagement.entity.Course;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Accessors(fluent = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CourseDTO {

    private int id;

    private String name;

    private String instructorName;

    private List<Integer> categoryIds;

    public CourseDTO(Course course) {
        this.id = course.id();
        this.name = course.name();
        if (course.instructor() != null) {
            this.instructorName = course.instructor().user().id();

        }
    }
}
