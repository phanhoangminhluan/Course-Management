package com.luanphm.CourseManagement.entity;

import com.luanphm.CourseManagement.entity.SharedEntity.MyBaseEntity;
import com.luanphm.CourseManagement.model.user.UserDTO;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Accessors(fluent = true)
@Entity
@Table(name = "User")
public class User extends MyBaseEntity<String> {

    @NotNull
    @Column(name = "password")
    private String password;

    @NotNull
    @Column(name = "email")
    private String email;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToMany
    @JoinTable(name = "student_concern", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;

    @ManyToMany
    @JoinTable(name = "course_student", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public User(String username) {
        this.id = username;
    }
    public User(UserDTO dto) {
        this.id = dto.username();
        this.password = dto.password();
        this.email = dto.email();
        this.firstName = dto.firstName();
        this.lastName = dto.lastName();
        this.role = new Role(dto.roleId());
    }
    public User(Instructor instructor) {
        this.id = instructor.user().id();
        this.password = instructor.user().password();
        this.email = instructor.user().email();
        this.firstName = instructor.user().firstName();
        this.lastName = instructor.user().lastName();
        this.role = new Role(instructor.user().role().id());
    }

    public User(String id, String password, String email, String firstName, String lastName, int roleId) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = new Role(roleId);
    }

    public User(String id, String password, String email, String firstName, String lastName, Role role) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }
    @Builder
    public User(String id, String password, String email, String firstName, String lastName, List<Category> categories, List<Course> courses, Role role) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.categories = categories;
        this.courses = courses;
        this.role = role;
    }

    public void addCategory(Category category) {
        if (this.categories == null) {
            this.categories = new ArrayList<>();
        }
        this.categories.add(category);
    }
}
