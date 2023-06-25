package id.co.indivara.jdt12.miniprojectbank.service;
import id.co.indivara.jdt12.miniprojectbank.entity.AccountBalance;
import id.co.indivara.jdt12.miniprojectbank.entity.AccountTransaction;
import id.co.indivara.jdt12.miniprojectbank.repository.AccountBalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountBalanceService {
    @Autowired
    static AccountBalanceRepository accountBalanceRepository;

    public static BigDecimal checkBalance(String accountId){
        AccountBalance accountBalance = accountBalanceRepository.findById(accountId).orElse(null);
        return accountBalance.getBalance();
    }

    //masih belum
    public List<AccountBalance> getAllAccountBalence(){
        return (List<AccountBalance>) accountBalanceRepository.findAll();
    }
}
