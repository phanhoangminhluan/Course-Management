package com.luanphm.CourseManagement.service;

import com.luanphm.CourseManagement.entity.CourseStudent;
import com.luanphm.CourseManagement.entity.CourseStudentId;
import com.luanphm.CourseManagement.model.course_student.CourseStudentDTO;
import com.luanphm.CourseManagement.repository.course_student.CourseStudentRepository;
import com.luanphm.CourseManagement.service.SharedService.MyAbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseStudentServiceImpl extends MyAbstractService<CourseStudent, CourseStudentId, CourseStudentDTO> implements CourseStudentService {

    @Autowired
    private CourseStudentRepository courseStudentRepository;

    @Override
    protected CourseStudentDTO instantiateDTO(CourseStudent entity) {
        return new CourseStudentDTO(entity);
    }

    @Override
    protected CourseStudent instantiateEntity(CourseStudentDTO dto) {
        return new CourseStudent(dto);
    }

    @Override
    protected void constructRepository() {
        this.repository = courseStudentRepository;
    }

    @Override
    public List<CourseStudentDTO> getAll() {
        return super.getAll();
    }

    @Override
    public CourseStudentDTO getById(CourseStudentId courseStudentId) {
        return super.getById(courseStudentId);
    }

    @Override
    public void add(CourseStudentDTO dto) {
        super.add(dto);
    }

    @Override
    public void update(CourseStudentDTO dto) {
        super.update(dto);
    }

    @Override
    public void deleteById(CourseStudentId courseStudentId) {
        super.deleteById(courseStudentId);
    }
}
