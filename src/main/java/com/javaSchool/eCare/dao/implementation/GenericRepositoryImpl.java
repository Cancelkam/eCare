package com.javaSchool.eCare.dao.implementation;


import com.javaSchool.eCare.dao.interfaces.GenericRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public class GenericRepositoryImpl<Entity,Integer> implements GenericRepository<Entity,Integer>{


    private final Class<Entity> entityClass;

    private SessionFactory session;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.session = sessionFactory;
    }

    public GenericRepositoryImpl() {
        entityClass = (Class<Entity>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    @Override
    public List<Entity> findAll(){
        return session.getCurrentSession()
                .createQuery("from " + entityClass.getName(), entityClass)
                .getResultList();
    }

//    @Override
//    public Entity save(Entity entity) {
//        session.getCurrentSession().persist(entity);
//        session.getCurrentSession().flush();
//        return entity;
//    }
//
//    @Override
//    public Entity update(Entity entity){
//        session.getCurrentSession()
//                .merge(entity);
//        return entity;
//    }
}
