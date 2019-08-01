package com.luanphm.CourseManagement.configuration.security_configuration;

import com.luanphm.CourseManagement.entity.Role;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;

@Data
@Getter
@Setter
@Accessors(fluent = true)
public class CustomUserDetail  extends User implements UserDetails, Serializable {

    private String email;

    private String firstName;

    private String lastName;

    public CustomUserDetail(String username, String password, Collection<? extends GrantedAuthority> authorities, String email, String firstName, String lastName) {
        super(username, password, authorities);
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
