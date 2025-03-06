package org.example.loanprocessingapp.LoanProcessingApp.service;


import org.example.loanprocessingapp.LoanProcessingApp.dao.CreditDecisionPersonDao;
import org.example.loanprocessingapp.LoanProcessingApp.models.CreditDecision;
import org.example.loanprocessingapp.LoanProcessingApp.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Service
public class CreditDecisionPersonService {

    private final CreditDecisionPersonDao creditDecisionPersonDao;

    @Autowired
    public CreditDecisionPersonService(CreditDecisionPersonDao creditDecisionPersonDao) {
        this.creditDecisionPersonDao = creditDecisionPersonDao;
    }
    @Transactional
    public CreditDecision createCreditDecision(Person person) {
        Random random = new Random();
        boolean approved = random.nextBoolean();
        CreditDecision decision = new CreditDecision(
                person,
                approved ? "Одобрено" : "Отказ",
                approved ? random.nextInt((int) (person.getDesiredLoanAmount() * 0.5), (int) (person.getDesiredLoanAmount() + 1)) : 0,
                approved ? random.nextInt(1, 12) : 0
        );
        creditDecisionPersonDao.saveCreditDecision(decision);
        return decision;
    }
    @Transactional
    public CreditDecision getCreditDecisionById(Long decisionId) {
        return creditDecisionPersonDao.getCreditDecision(decisionId);
    }

    @Transactional
    public List<CreditDecision> getDecisions() {
        return creditDecisionPersonDao.getAllDecisions();
    }
}