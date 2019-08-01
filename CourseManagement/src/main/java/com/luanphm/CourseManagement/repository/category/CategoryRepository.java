package com.luanphm.CourseManagement.repository.category;

import com.luanphm.CourseManagement.entity.Category;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

public interface CategoryRepository extends CategoryJpaRepository, CategoryCustomRepository{


}
