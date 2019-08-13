package com.luanphm.CourseManagement.entity;

import com.luanphm.CourseManagement.entity.SharedEntity.MyBaseEntity;
import com.luanphm.CourseManagement.model.role.RoleDTO;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Data
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(fluent = true)
@Entity
@Table(name = "Role")
public class Role extends MyBaseEntity<Integer> {

    @NotNull
    @Column(name = "name")
    private String name;

    public Role(int id) {
        this.id = id;
    }

    @Builder
    public Role(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Role(RoleDTO dto) {
        this.id = dto.id();
        this.name = dto.name();
    }
}
