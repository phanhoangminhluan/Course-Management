package com.luanphm.CourseManagement.service;

import com.luanphm.CourseManagement.entity.Instructor;
import com.luanphm.CourseManagement.model.instructor.InstructorDTO;
import com.luanphm.CourseManagement.repository.instructor.InstructorRepository;
import com.luanphm.CourseManagement.service.SharedService.MyAbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImpl extends MyAbstractService<Instructor, String, InstructorDTO> implements InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    @Override
    protected InstructorDTO instantiateDTO(Instructor entity) {
        return new InstructorDTO(entity);
    }

    @Override
    protected Instructor instantiateEntity(InstructorDTO dto) {
        return new Instructor(dto);
    }

    @Override
    protected void constructRepository() {
        this.repository = instructorRepository;
    }

    @Override
    public List<InstructorDTO> getAll() {
        return super.getAll();
    }

    @Override
    public InstructorDTO getById(String s) {
        return super.getById(s);
    }

    @Override
    public void add(InstructorDTO dto) {
        super.add(dto);
    }

    @Override
    public void update(InstructorDTO dto) {
        super.update(dto);
    }

    @Override
    public void deleteById(String s) {
        super.deleteById(s);
    }
}
