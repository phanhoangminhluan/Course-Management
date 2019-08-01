package com.luanphm.CourseManagement.service;

import com.luanphm.CourseManagement.entity.Category;
import com.luanphm.CourseManagement.entity.User;
import com.luanphm.CourseManagement.model.category.CategoryDTO;
import com.luanphm.CourseManagement.model.user.UserDTO;
import com.luanphm.CourseManagement.model.user.UserWithRoleDTO;
import com.luanphm.CourseManagement.repository.user.UserRepository;
import com.luanphm.CourseManagement.service.SharedService.MyAbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl extends MyAbstractService<User, String, UserDTO> implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    protected UserDTO instantiateDTO(User entity) {
        return new UserDTO(entity);
    }

    @Override
    protected User instantiateEntity(UserDTO dto) {
        return new User(dto);
    }

    @Override
    protected void constructRepository() {
        this.repository = userRepository;
    }

    @Override
    public void addCategoryToUser(String userId, int categoryId) {
        User user = new User(userId);
        Category category = new Category(categoryId);
        user.addCategory(category);
        userRepository.save(user);
    }

    @Override
    public List<CategoryDTO> getCategoriesByUser(String userId) {
        List<Category> categories = userRepository.getCategoriesByUserId(userId);
        List<CategoryDTO> dtos = new ArrayList<>();
        categories.forEach(category -> dtos.add(new CategoryDTO(category)));
        return dtos;
    }

    @Override
    public UserWithRoleDTO getUserWithRole(String username) {
        User user = userRepository.getUserWithRole(username);
        UserWithRoleDTO dto = new UserWithRoleDTO(user);
        return dto;
    }

    @Override
    public void add(UserDTO dto) {
        dto.password(BCrypt.hashpw(dto.password(), BCrypt.gensalt(12)));
        super.add(dto);
    }

    @Override
    public List<UserDTO> getAll() {
        return super.getAll();
    }

    @Override
    public UserDTO getById(String s) {
        return super.getById(s);
    }

    @Override
    public void update(UserDTO dto) {
        super.update(dto);
    }

    @Override
    public void deleteById(String s) {
        super.deleteById(s);
    }

    @Override
    protected List<UserDTO> mapEntityToModel(List<User> entities) {
        return super.mapEntityToModel(entities);
    }
}
