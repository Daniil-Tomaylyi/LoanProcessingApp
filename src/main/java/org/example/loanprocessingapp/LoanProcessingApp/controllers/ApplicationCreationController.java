package org.example.loanprocessingapp.LoanProcessingApp.controllers;


import org.example.loanprocessingapp.LoanProcessingApp.models.CreditDecision;
import org.example.loanprocessingapp.LoanProcessingApp.models.Person;
import org.example.loanprocessingapp.LoanProcessingApp.service.ApplicationCreationService;
import org.example.loanprocessingapp.LoanProcessingApp.service.CreditDecisionPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/credit")
public class ApplicationCreationController {

    private final ApplicationCreationService applicationCreationService;

    private final CreditDecisionPersonService creditDecisionPersonService;

    @Autowired
    public ApplicationCreationController(ApplicationCreationService applicationCreationService, CreditDecisionPersonService creditDecisionPersonService) {
        this.applicationCreationService = applicationCreationService;
        this.creditDecisionPersonService = creditDecisionPersonService;
    }

    @GetMapping("/new")
    public String newPerson(Model model) {
        model.addAttribute("person", new Person());
        return "application_creation";
    }

    @PostMapping("/apply")
    public String Create(@ModelAttribute("person") Person person) {
        applicationCreationService.addPerson(person);
        CreditDecision decision = creditDecisionPersonService.createCreditDecision(person);
        return "redirect:/credit/decision/" + decision.getId();
    }

}
