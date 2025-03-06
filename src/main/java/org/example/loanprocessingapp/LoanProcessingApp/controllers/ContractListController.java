package org.example.loanprocessingapp.LoanProcessingApp.controllers;

import org.example.loanprocessingapp.LoanProcessingApp.models.Contract;
import org.example.loanprocessingapp.LoanProcessingApp.service.CreditContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/contracts")
public class ContractListController {

    private final CreditContractService creditContractService;

    @Autowired
    public ContractListController(CreditContractService creditContractService) {
        this.creditContractService = creditContractService;
    }

    @GetMapping()
    public String getAllContract(Model model){
        List<Contract> contracts = creditContractService.getContracts();
        model.addAttribute("contracts", contracts);
        return "contracts";
    }
}
