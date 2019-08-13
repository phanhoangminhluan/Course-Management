package com.luanphm.CourseManagement.entity;

import com.luanphm.CourseManagement.entity.SharedEntity.MyBaseEntity;
import com.luanphm.CourseManagement.model.course.CourseDTO;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(fluent = true)
@Entity
@Table(name = "course")
public class Course extends MyBaseEntity<Integer> {

    @Column(name = "name")
    private String name;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "course_category",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;

    public Course(int courseId) {
        this.id = courseId;
    }

    public Course(int id, String name) {
        this.id = id;
        this.name = name;
    }


    public Course(CourseDTO dto) {
        this.id = dto.id();
        this.name = dto.name();
        this.instructor
                .builder()
                    .user(new User(dto.instructorName()))
                .build();
    }

    public Course(int id, String name, String username) {
        this.id = id;
        this.name = name;

        this.instructor = Instructor
                .builder()
                    .user(new User(username))
                .build();
    }
}
