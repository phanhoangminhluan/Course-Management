package com.luanphm.CourseManagement.model.user;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.luanphm.CourseManagement.entity.User;
import com.luanphm.CourseManagement.exception_handling.CustomExceptions.RecordNotFoundException;
import lombok.*;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Accessors(fluent = true)
public class UserDTO {

    @NotEmpty(message = "user name must not be empty")
    private String username;

    @NotEmpty(message = "last name must not be empty")
    private String password;

    @NotEmpty(message = "email must not be empty")
    @Email(message = "email should be a valid email")
    private String email;

    private String firstName;

    private String lastName;

    private int roleId;

    public UserDTO(User user) {
        if (user != null) {
            this.username = user.id();
            this.password = user.password();
            this.email = user.email();
            this.firstName = user.firstName();
            this.lastName = user.lastName();
            this.roleId = user.role().id();
        } else {
            throw new RecordNotFoundException("USER NOT FOUND");
        }
    }
}
