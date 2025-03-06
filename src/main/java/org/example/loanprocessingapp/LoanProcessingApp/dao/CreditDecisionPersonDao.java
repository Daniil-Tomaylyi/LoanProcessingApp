package org.example.loanprocessingapp.LoanProcessingApp.dao;


import org.example.loanprocessingapp.LoanProcessingApp.models.CreditDecision;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CreditDecisionPersonDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public CreditDecisionPersonDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void saveCreditDecision(CreditDecision creditDecision) {
        sessionFactory.getCurrentSession().persist(creditDecision);
    }

    @Transactional
    public CreditDecision getCreditDecision(Long decisionId) {
        return sessionFactory.getCurrentSession().get(CreditDecision.class, decisionId);
    }

    @Transactional
    public List<CreditDecision> getAllDecisions() {
        String hql = "FROM CreditDecision c ORDER BY c.id ASC";
        return sessionFactory.getCurrentSession().createQuery(hql, CreditDecision.class).getResultList();
    }
}
