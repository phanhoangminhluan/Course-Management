package com.luanphm.CourseManagement.controller;

import com.luanphm.CourseManagement.controller.SharedController.MyAbstractController;
import com.luanphm.CourseManagement.model.instructor.InstructorDTO;
import com.luanphm.CourseManagement.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/instructors")
public class InstructorController extends MyAbstractController<String, InstructorDTO> {

    @Autowired
    private InstructorService instructorService;

    @Override
    protected void constructService() {
        this.service = instructorService;
    }
}
