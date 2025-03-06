package org.example.loanprocessingapp.LoanProcessingApp.service;


import org.example.loanprocessingapp.LoanProcessingApp.dao.PersonDao;
import org.example.loanprocessingapp.LoanProcessingApp.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ApplicationCreationService {

    private final PersonDao personDao;

    @Autowired
    public ApplicationCreationService(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Transactional(transactionManager = "transactionManager")
    public void addPerson(Person person) {
        personDao.savePerson(person);
    }


}
