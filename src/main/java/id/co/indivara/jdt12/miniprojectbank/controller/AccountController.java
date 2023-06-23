package id.co.indivara.jdt12.miniprojectbank.controller;
import id.co.indivara.jdt12.miniprojectbank.entity.Account;
import id.co.indivara.jdt12.miniprojectbank.model.SaveAccount;
import id.co.indivara.jdt12.miniprojectbank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
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
}
