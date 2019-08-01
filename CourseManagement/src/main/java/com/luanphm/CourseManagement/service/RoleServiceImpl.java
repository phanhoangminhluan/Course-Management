package com.luanphm.CourseManagement.service;

import com.luanphm.CourseManagement.entity.Role;
import com.luanphm.CourseManagement.model.role.RoleDTO;
import com.luanphm.CourseManagement.repository.role.RoleRepository;
import com.luanphm.CourseManagement.service.SharedService.MyAbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl extends MyAbstractService<Role, Integer, RoleDTO> implements RoleService{

    @Autowired
    private RoleRepository roleRepository;

    @Override
    protected RoleDTO instantiateDTO(Role entity) {
        return new RoleDTO(entity);
    }

    @Override
    protected Role instantiateEntity(RoleDTO dto) {
        return new Role(dto);
    }

    @Override
    protected void constructRepository() {
        this.repository = roleRepository;
    }

    @Override
    public List<RoleDTO> getAll() {
        return super.getAll();
    }

    @Override
    public RoleDTO getById(Integer integer) {
        return super.getById(integer);
    }

    @Override
    public void add(RoleDTO dto) {
        super.add(dto);
    }

    @Override
    public void update(RoleDTO dto) {
        super.update(dto);
    }

    @Override
    public void deleteById(Integer integer) {
        super.deleteById(integer);
    }
}
