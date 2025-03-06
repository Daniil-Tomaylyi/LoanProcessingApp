package org.example.loanprocessingapp.LoanProcessingApp.service;

import org.example.loanprocessingapp.LoanProcessingApp.dao.CreditContractDao;
import org.example.loanprocessingapp.LoanProcessingApp.models.Contract;
import org.example.loanprocessingapp.LoanProcessingApp.models.CreditDecision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class CreditContractService {

    private final CreditContractDao contractDao;

    @Autowired
    public CreditContractService(CreditContractDao contractDao) {
        this.contractDao = contractDao;
    }

    @Transactional
    public Contract createContract(CreditDecision decision) {
        Contract contract = new Contract(decision.getPerson(), decision.getApprovedAmount(), decision.getTerm(),
                LocalDate.now().toString(), "Не подписан");
        contractDao.saveContract(contract);
        return contract;
    }

    @Transactional
    public void updateContract(Contract contract) {
        contractDao.updateContract(contract);
    }

    @Transactional
    public Contract getCreditContractById(Long contractId) {
        return contractDao.getCreditContract(contractId);
    }

    @Transactional
    public List<Contract> getContracts() {
        return contractDao.getAllContract();
    }
}
