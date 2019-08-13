package com.luanphm.CourseManagement.entity;


import com.luanphm.CourseManagement.entity.SharedEntity.MyBaseEntity;
import com.luanphm.CourseManagement.model.instructor.InstructorDTO;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(fluent = true)
@Entity
@Table(name = "instructor")
public class Instructor extends MyBaseEntity<String> {

    public Instructor(String instructorId) {
        this.id = instructorId;
    }

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    @Column(name = "youtube_channel")
    private String youtubeChannel;

    @Column(name = "salary")
    private double salary;

    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, mappedBy = "instructor")
    private List<Course> courses;

    public Instructor(InstructorDTO dto) {
        this.id = dto.id();
        this.user = new User(dto.id());
        this.youtubeChannel = dto.youtubeChannel();
        this.salary = dto.salary();
    }

    public Instructor(String id, String youtubeChannel, double salary) {
        this.id = id;
        this.user = new User(id);
        this.youtubeChannel = youtubeChannel;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instructor that = (Instructor) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
