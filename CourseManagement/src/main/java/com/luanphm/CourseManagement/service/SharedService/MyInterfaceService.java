package com.luanphm.CourseManagement.service.SharedService;

import java.util.ArrayList;
import java.util.List;

public interface MyInterfaceService<ID, M> {

    List<M> getAll();

    M getById(ID id);

    void add(M dto);

    void update(M dto);

    void deleteById(ID id);
}
