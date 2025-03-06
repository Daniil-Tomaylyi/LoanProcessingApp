package org.example.loanprocessingapp.LoanProcessingApp.controllers;



import org.example.loanprocessingapp.LoanProcessingApp.models.CreditDecision;
import org.example.loanprocessingapp.LoanProcessingApp.service.CreditDecisionPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/credit")
public class CreditDecisionController {

    private final CreditDecisionPersonService creditDecisionPersonService;

    @Autowired
    public CreditDecisionController(CreditDecisionPersonService creditDecisionPersonService) {
        this.creditDecisionPersonService = creditDecisionPersonService;
    }

    @GetMapping("/decision/{id}")
    public String getCreditDecision(@PathVariable("id") Long decisionId, Model model) {
        CreditDecision decision = creditDecisionPersonService.getCreditDecisionById(decisionId);
        model.addAttribute("creditDecision", decision);
        return "credit_decision";
    }

}
