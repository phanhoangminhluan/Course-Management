package com.luanphm.CourseManagement.repository.user;

import com.luanphm.CourseManagement.entity.Category;
import com.luanphm.CourseManagement.entity.User;
import com.luanphm.CourseManagement.repository.MyAbstractSession;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserCustomRepositoryImpl extends MyAbstractSession implements UserCustomRepository {

//    @Override
//    public void djdjdjdjdjdj(User entity) {
//
//        Session session = getSession();
//
//        session.save(entity);
//
//    }
}
