package com.luanphm.CourseManagement.model.course;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.luanphm.CourseManagement.entity.Course;
import lombok.*;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Accessors(fluent = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CourseByInstructorDTO {

    private int id;
    private String name;

    public CourseByInstructorDTO(Course course) {
        this.id = course.id();
        this.name = course.name();
    }
}
