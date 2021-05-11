package com.javaSchool.eCare.dao.implementation;

import com.javaSchool.eCare.dao.interfaces.ContractRepository;
import com.javaSchool.eCare.model.entity.Contract;
import com.javaSchool.eCare.model.entity.UserEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContractRepositoryImpl implements ContractRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Contract> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Contract").list();
    }

    @Override
    public void add(Contract contract) {
        sessionFactory.getCurrentSession().save(contract);
    }

    @Override
    public void update(Contract contract) {
        sessionFactory.getCurrentSession().merge(contract);
    }
}