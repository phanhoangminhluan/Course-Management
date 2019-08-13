package com.luanphm.CourseManagement.configuration.security_configuration;

import com.luanphm.CourseManagement.model.user.UserWithRoleDTO;
import com.luanphm.CourseManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        System.out.println("UserDetailServiceImpl: loadUserByUsername()");
        UserWithRoleDTO dto = userService.getUserWithRole(username);
        if (dto == null) {
            throw new UsernameNotFoundException("USERNAME NOT FOUND");
        }

        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(dto.roleDTO().name()));

        CustomUserDetail userDetail = new CustomUserDetail(dto.username(), dto.password(), authorities, dto.email(), dto.firstName(), dto.lastName());
        System.out.println(userDetail);
        return userDetail;
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        User user = userService.getUser(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("Đéo thấy rồi, bạn tôi ơi");
//        }
//
//        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
//        Role role = user.getRole();
//        authorities.add(new SimpleGrantedAuthority(role.getName()));
//
//        CustomUserDetails userDetails = new CustomUserDetails(user.getEmail(), user.getPassword(), authorities);
//        userDetails.setEmail(user.getEmail());
//        userDetails.setFirstName(user.getFirstName());
//        userDetails.setLastName(user.getLastName());
//
//        return userDetails;
//    }
}
