package com.luanphm.CourseManagement.entity;


import com.luanphm.CourseManagement.entity.SharedEntity.MyBaseEntity;
import com.luanphm.CourseManagement.model.category.CategoryDTO;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Data
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(fluent = true)
@Entity
@Table(name = "category")
public class Category extends MyBaseEntity<Integer> {

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "course_category",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;


    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category(CategoryDTO dto) {
        this.id = dto.id();
        this.name = dto.name();
    }

    public Category(int categoryId) {
        this.id = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return id == category.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
