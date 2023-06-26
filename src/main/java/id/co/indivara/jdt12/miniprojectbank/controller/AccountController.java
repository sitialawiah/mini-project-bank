package id.co.indivara.jdt12.miniprojectbank.controller;
import id.co.indivara.jdt12.miniprojectbank.entity.Account;
import id.co.indivara.jdt12.miniprojectbank.model.HistoryTransaction;
import id.co.indivara.jdt12.miniprojectbank.model.SaveAccount;
import id.co.indivara.jdt12.miniprojectbank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {
    @Autowired
    AccountService accountService;

    @PostMapping("/saveaccount")
    public Boolean saveAccount(@RequestBody SaveAccount saveAccount){
        Boolean hasil = accountService.saveAccount(saveAccount);
        return hasil;
    }

    @GetMapping("/account")
    public List<Account> getAllaccount() {
        return accountService.getAllAccount();
    }


//get transaction history
    @GetMapping("/historytransaction/{accountId}")
    public HistoryTransaction gethistory (@PathVariable("accountId") String id) throws Exception {
        return accountService.historyTransaction(id);
    }
}
