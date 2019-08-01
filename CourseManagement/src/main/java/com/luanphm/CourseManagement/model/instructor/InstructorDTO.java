package com.luanphm.CourseManagement.model.instructor;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.luanphm.CourseManagement.entity.Instructor;
import com.luanphm.CourseManagement.entity.User;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Accessors(fluent = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class InstructorDTO {

    private String id;

    private String youtubeChannel;

    private double salary;


    public InstructorDTO(Instructor instructor) {
        this.id = instructor.id();
        this.youtubeChannel = instructor.youtubeChannel();
        this.salary = instructor.salary();
    }
}
