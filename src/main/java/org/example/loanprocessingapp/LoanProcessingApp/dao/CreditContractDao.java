package org.example.loanprocessingapp.LoanProcessingApp.dao;

import org.example.loanprocessingapp.LoanProcessingApp.models.Contract;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CreditContractDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public CreditContractDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void saveContract(Contract contract) {
        sessionFactory.getCurrentSession().persist(contract);
    }

    @Transactional
    public void updateContract(Contract contract) {
        sessionFactory.getCurrentSession().merge(contract);
    }

    @Transactional
    public Contract getCreditContract(Long contractId) {
        return sessionFactory.getCurrentSession().get(Contract.class, contractId);
    }

    @Transactional
    public List<Contract> getAllContract() {
        String hql = "FROM Contract c ORDER BY c.signDate DESC";
        return sessionFactory.getCurrentSession().createQuery(hql, Contract.class).getResultList();
    }
}
