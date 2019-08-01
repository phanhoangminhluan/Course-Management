package com.luanphm.CourseManagement.controller;

import com.luanphm.CourseManagement.controller.SharedController.MyAbstractController;
import com.luanphm.CourseManagement.model.course.CategoryCourseIdDTO;
import com.luanphm.CourseManagement.model.course.CourseByInstructorDTO;
import com.luanphm.CourseManagement.model.course.CourseDTO;
import com.luanphm.CourseManagement.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/courses")
public class CourseController extends MyAbstractController<Integer, CourseDTO> {

    @Autowired
    private CourseService courseService;

    @Override
    protected void constructService() {
        this.service = courseService;
    }

    @GetMapping("/instructors/{id}")
    public List<CourseByInstructorDTO> getCoursesByInstructor(@PathVariable("id") String id) {
        return courseService.getCoursesByInstructor(id);
    }

    @PostMapping("categories")
    public void addCategoryToCourse(@RequestBody CategoryCourseIdDTO dto) {
        courseService.addCategoryToCourse(dto);
    }

    @GetMapping("{id}/categories/id")
    public List<Integer> getCategoryIdsByCourseId(@PathVariable("id") int courseId) {
        return courseService.getCategoryIdsByCourseId(courseId);
    }
}
