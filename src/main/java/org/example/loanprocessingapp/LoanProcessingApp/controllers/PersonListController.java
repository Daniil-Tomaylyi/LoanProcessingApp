package org.example.loanprocessingapp.LoanProcessingApp.controllers;


import org.example.loanprocessingapp.LoanProcessingApp.models.Person;
import org.example.loanprocessingapp.LoanProcessingApp.service.ApplicationCreationService;
import org.example.loanprocessingapp.LoanProcessingApp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("clients")
public class PersonListController {

    private final PersonService personService;

    @Autowired
    public PersonListController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping()
    public String getAllPerson(Model model) {
        List<Person> persons = personService.getPersons();
        model.addAttribute("persons", persons);
        return "clients";
    }

    @GetMapping("/search")
    public String GetFilterPerson(@RequestParam("category") String category, @RequestParam("query") String query, @RequestParam(name = "action", required = false) String action, Model model) {
        List<Person> persons = "search".equals(action)
                ? personService.getFilteredPersonsByCategory(category, query)
                : personService.getPersons();
        model.addAttribute("persons", persons);
        return "clients";
    }
}
