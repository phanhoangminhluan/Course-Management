package com.luanphm.CourseManagement.model.course_student;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.luanphm.CourseManagement.entity.CourseStudent;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Accessors(fluent = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CourseStudentDTO {

    private String studentId;
    private int courseId;
    private Date dateEnroll;

    public CourseStudentDTO(CourseStudent entity) {
        this.studentId = entity.id().studentId();
        this.courseId = entity.id().courseId();
        this.dateEnroll = entity.dateEnroll();
    }
}
