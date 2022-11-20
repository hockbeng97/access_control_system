package com.test.web.core.dao.impl;

import com.querydsl.core.types.EntityPath;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.sql.*;
import com.test.web.api.entity.AccessBean;
import com.test.web.api.entity.QAccessBean;
import com.test.web.api.model.AccessModel;
import com.test.web.api.model.AddAccessModel;
import com.test.web.core.dao.custom.AccessDaoCustom;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import java.util.Optional;

@Repository
public class AccessDaoImpl implements AccessDaoCustom {

    @PersistenceContext
    private EntityManager entityManager;

    private final QAccessBean accessBean = QAccessBean.accessBean;

    @Override
    public AccessBean getByEmailAndFeatureName(String email, String feature) {
        JPAQueryFactory q = new JPAQueryFactory(entityManager);
        return q.selectFrom(accessBean).where(accessBean.accessLinkKey.email.eq(email).and(accessBean.accessLinkKey.featureName.eq(feature))).fetchOne();
    }

    @Override
    public void addAccess(AccessBean userAccessModel){
        entityManager.persist(userAccessModel);
    }

    @Override
    public void updateAccess(AccessBean userAccessModel){
        entityManager.merge(userAccessModel);
    }
}
