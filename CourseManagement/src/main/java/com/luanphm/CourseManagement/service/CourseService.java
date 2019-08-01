package com.luanphm.CourseManagement.service;

import com.luanphm.CourseManagement.entity.Category;
import com.luanphm.CourseManagement.entity.Course;
import com.luanphm.CourseManagement.model.category.CategoryDTO;
import com.luanphm.CourseManagement.model.course.CategoryCourseIdDTO;
import com.luanphm.CourseManagement.model.course.CourseByInstructorDTO;
import com.luanphm.CourseManagement.model.course.CourseDTO;
import com.luanphm.CourseManagement.service.SharedService.MyInterfaceService;

import java.util.List;

public interface CourseService extends MyInterfaceService<Integer, CourseDTO> {

    List<CourseByInstructorDTO> getCoursesByInstructor(String id);

    void addCategoryToCourse(CategoryCourseIdDTO dto);

    List<Integer> getCategoryIdsByCourseId(int courseId);

}
