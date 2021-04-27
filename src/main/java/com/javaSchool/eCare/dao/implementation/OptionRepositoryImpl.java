package com.javaSchool.eCare.dao.implementation;

import com.javaSchool.eCare.dao.interfaces.OptionRepository;
import com.javaSchool.eCare.model.entity.Option;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OptionRepositoryImpl implements OptionRepository {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Option> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Option").list();
    }

    @Override
    public void add(Option option) {
        sessionFactory.getCurrentSession().save(option);
    }

    @Override
    public void update(Option option) {
        sessionFactory.getCurrentSession().merge(option);
    }
}
