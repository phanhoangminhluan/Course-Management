package com.luanphm.CourseManagement.controller;

import com.luanphm.CourseManagement.controller.SharedController.MyAbstractController;
import com.luanphm.CourseManagement.entity.CourseStudentId;
import com.luanphm.CourseManagement.model.course_student.CourseStudentDTO;
import com.luanphm.CourseManagement.service.CourseStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/courseStudents")
public class CourseStudentController extends MyAbstractController<CourseStudentId, CourseStudentDTO> {

    @Autowired
    private CourseStudentService courseStudentService;

    @Override
    protected void constructService() {
        this.service = courseStudentService;
    }
}
