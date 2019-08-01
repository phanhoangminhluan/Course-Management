package com.luanphm.CourseManagement.service;

import com.luanphm.CourseManagement.entity.Course;
import com.luanphm.CourseManagement.model.course.CategoryCourseIdDTO;
import com.luanphm.CourseManagement.model.course.CourseByInstructorDTO;
import com.luanphm.CourseManagement.model.course.CourseDTO;
import com.luanphm.CourseManagement.repository.course.CourseRepository;
import com.luanphm.CourseManagement.service.SharedService.MyAbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl extends MyAbstractService<Course, Integer, CourseDTO> implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    protected CourseDTO instantiateDTO(Course entity) {
        return new CourseDTO(entity);
    }

    @Override
    protected Course instantiateEntity(CourseDTO dto) {
        return new Course(dto);
    }

    @Override
    protected void constructRepository() {
        this.repository = courseRepository;
    }

    @Override
    public List<CourseByInstructorDTO> getCoursesByInstructor(String id) {

        List<Course> courses = courseRepository.getCoursesByInstructor(id);
        List<CourseByInstructorDTO> dtos = new ArrayList<>();
        courses.forEach(course -> dtos.add(new CourseByInstructorDTO(course)));
        return dtos;
    }

    @Override
    public void addCategoryToCourse(CategoryCourseIdDTO dto) {
        courseRepository.addCategoryToCourse(dto.categoryId(), dto.courseId());
    }

    @Override
    public List<Integer> getCategoryIdsByCourseId(int courseId) {
        return courseRepository.getCategoriesByCourse(courseId);
    }

    @Override
    public List<CourseDTO> getAll() {
        List<CourseDTO> dtos = super.getAll();

        dtos.forEach(courseDTO -> {
            courseDTO.categoryIds(courseRepository.getCategoriesByCourse(courseDTO.id()));
        });
        return dtos;
    }

    @Override
    public CourseDTO getById(Integer integer) {
        return super.getById(integer);
    }

    @Override
    public void add(CourseDTO dto) {
        super.add(dto);
    }

    @Override
    public void update(CourseDTO dto) {
        super.update(dto);
    }

    @Override
    public void deleteById(Integer integer) {
        super.deleteById(integer);
    }
}
