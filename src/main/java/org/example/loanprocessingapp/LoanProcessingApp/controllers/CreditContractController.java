package org.example.loanprocessingapp.LoanProcessingApp.controllers;



import org.example.loanprocessingapp.LoanProcessingApp.models.Contract;
import org.example.loanprocessingapp.LoanProcessingApp.models.CreditDecision;
import org.example.loanprocessingapp.LoanProcessingApp.service.CreditContractService;
import org.example.loanprocessingapp.LoanProcessingApp.service.CreditDecisionPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/credit")
public class CreditContractController {

    private final CreditContractService creditContractService;
    private final CreditDecisionPersonService creditDecisionPersonService;

    @Autowired
    public CreditContractController(CreditContractService creditContractService, CreditDecisionPersonService creditDecisionPersonService) {
        this.creditContractService = creditContractService;
        this.creditDecisionPersonService = creditDecisionPersonService;
    }

    @GetMapping("/contract/{id}")
    public String getCreditContract(@PathVariable Long id, Model model){
        CreditDecision decision = creditDecisionPersonService.getCreditDecisionById(id);
        Contract contract = creditContractService.createContract(decision);
        model.addAttribute("contract", contract);
        return "credit_contract";
    }

    @PostMapping("/contract/sign")
    public String updateCreditContract(@RequestParam("contractId") Long contractId){
        Contract contract = creditContractService.getCreditContractById(contractId);
        contract.setStatus("Подписан");
        creditContractService.updateContract(contract);
        return "redirect:/";
    }
}
