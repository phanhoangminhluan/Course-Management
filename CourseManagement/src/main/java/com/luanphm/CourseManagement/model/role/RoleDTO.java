package com.luanphm.CourseManagement.model.role;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.luanphm.CourseManagement.entity.Role;
import lombok.*;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(fluent = true)
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@ToString
public class RoleDTO {

    private int id;

    private String name;

    public RoleDTO(Role role) {
        this.id = role.id();
        this.name = role.name();
    }
}
