package com.luanphm.CourseManagement.service;

import com.luanphm.CourseManagement.entity.CourseStudentId;
import com.luanphm.CourseManagement.model.course_student.CourseStudentDTO;
import com.luanphm.CourseManagement.service.SharedService.MyInterfaceService;

import java.util.List;

public interface CourseStudentService extends MyInterfaceService<CourseStudentId, CourseStudentDTO> {
    @Override
    List<CourseStudentDTO> getAll();

    @Override
    CourseStudentDTO getById(CourseStudentId courseStudentId);

    @Override
    void add(CourseStudentDTO dto);

    @Override
    void update(CourseStudentDTO dto);

    @Override
    void deleteById(CourseStudentId courseStudentId);
}
