package com.luanphm.CourseManagement.service;


import com.luanphm.CourseManagement.entity.Category;
import com.luanphm.CourseManagement.model.category.CategoryDTO;
import com.luanphm.CourseManagement.repository.category.CategoryRepository;
import com.luanphm.CourseManagement.service.SharedService.MyAbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl extends MyAbstractService<Category, Integer, CategoryDTO> implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    protected CategoryDTO instantiateDTO(Category entity) {
        return new CategoryDTO(entity);
    }

    @Override
    protected Category instantiateEntity(CategoryDTO dto) {
        return new Category(dto);
    }

    @Override
    protected void constructRepository() {
        this.repository = categoryRepository;
    }

    @Override
    public List<CategoryDTO> getAll() {
        return super.getAll();
    }

    @Override
    public CategoryDTO getById(Integer integer) {
        return super.getById(integer);
    }

    @Override
    public void add(CategoryDTO dto) {
        super.add(dto);
    }

    @Override
    public void update(CategoryDTO dto) {
        super.update(dto);
    }

    @Override
    public void deleteById(Integer integer) {
        super.deleteById(integer);
    }
}
