package com.luanphm.CourseManagement.controller;

import com.luanphm.CourseManagement.controller.SharedController.MyAbstractController;
import com.luanphm.CourseManagement.entity.Category;
import com.luanphm.CourseManagement.model.category.CategoryDTO;
import com.luanphm.CourseManagement.model.user.UserDTO;
import com.luanphm.CourseManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController extends MyAbstractController<String, UserDTO> {

    @Autowired
    private UserService userService;

    @Override
    protected void constructService() {
        this.service = userService;
    }

    @GetMapping("{id}/categories")
    public List<CategoryDTO> getCategoriesByUserId(@PathVariable("id") String id) {
        return userService.getCategoriesByUser(id);
    }
}
