package org.example.loanprocessingapp.LoanProcessingApp.dao;


import org.example.loanprocessingapp.LoanProcessingApp.models.Person;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PersonDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public PersonDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(transactionManager = "transactionManager")
    public void savePerson(Person person) {
        sessionFactory.getCurrentSession().persist(person);
    }

    @Transactional
    public List<Person> getAllPerson() {
        String hql = "FROM Person p ORDER BY p.id ASC";
        return sessionFactory.getCurrentSession().createQuery(hql, Person.class).getResultList();
    }

    @Transactional
    public List<Person> filterPersons(String category, String query) {
        String hql = switch (category) {
            case "name" -> "FROM Person p where p.firstName = :query";
            case "phone" -> "FROM Person p where p.phone = :query";
            case "passport" -> "FROM Person p where p.passportNumber = :query";
            default -> throw new IllegalArgumentException("Неизвестная категория: " + category);
        };
        return sessionFactory.getCurrentSession().createQuery(hql, Person.class).setParameter("query", query).getResultList();
    }
}
