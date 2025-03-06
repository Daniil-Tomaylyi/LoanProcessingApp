package org.example.loanprocessingapp.LoanProcessingApp.controllers;


import org.example.loanprocessingapp.LoanProcessingApp.models.CreditDecision;
import org.example.loanprocessingapp.LoanProcessingApp.service.CreditDecisionPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("decisions")
public class DecisionListController {

    private final CreditDecisionPersonService creditDecisionPersonService;

    @Autowired
    public DecisionListController(CreditDecisionPersonService creditDecisionPersonService) {
        this.creditDecisionPersonService = creditDecisionPersonService;
    }

    @GetMapping()
    public String getAllDecisions(Model model) {
        List<CreditDecision> decisions = creditDecisionPersonService.getDecisions();
        model.addAttribute("decisions", decisions);
        return "decisions";
    }
}
