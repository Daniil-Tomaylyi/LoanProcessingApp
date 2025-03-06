package org.example.loanprocessingapp.LoanProcessingApp.service;

import org.example.loanprocessingapp.LoanProcessingApp.dao.PersonDao;
import org.example.loanprocessingapp.LoanProcessingApp.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Transactional
    public List<Person> getPersons() {
        return personDao.getAllPerson();
    }

    @Transactional
    public List<Person> getFilteredPersonsByCategory(String category, String query) {
        return personDao.filterPersons(category, query);
    }
}
