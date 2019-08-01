package com.luanphm.CourseManagement.controller;

import com.luanphm.CourseManagement.controller.SharedController.MyAbstractController;
import com.luanphm.CourseManagement.model.category.CategoryDTO;
import com.luanphm.CourseManagement.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/categories")
public class CategoryController extends MyAbstractController<Integer, CategoryDTO> {

    @Autowired
    private CategoryService categoryService;

    @Override
    protected void constructService() {
        this.service = categoryService;
    }
}
