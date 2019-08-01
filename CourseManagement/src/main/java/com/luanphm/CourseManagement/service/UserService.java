package com.luanphm.CourseManagement.service;

import com.luanphm.CourseManagement.model.category.CategoryDTO;
import com.luanphm.CourseManagement.model.user.UserDTO;
import com.luanphm.CourseManagement.model.user.UserWithRoleDTO;
import com.luanphm.CourseManagement.service.SharedService.MyInterfaceService;

import java.util.List;

public interface UserService extends MyInterfaceService<String, UserDTO> {

    void addCategoryToUser(String userId, int categoryId);

    List<CategoryDTO> getCategoriesByUser(String userId);

    UserWithRoleDTO getUserWithRole(String username);

}
