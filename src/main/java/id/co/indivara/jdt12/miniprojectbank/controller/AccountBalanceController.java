package id.co.indivara.jdt12.miniprojectbank.controller;
import id.co.indivara.jdt12.miniprojectbank.entity.AccountBalance;
import id.co.indivara.jdt12.miniprojectbank.repository.AccountBalanceRepository;
import id.co.indivara.jdt12.miniprojectbank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountBalanceController {
    @Autowired
    AccountService accountService;
    @Autowired
    AccountBalanceRepository accountBalanceRepository;

    @GetMapping("/accountBalanceById/{balanceId}")
    public AccountBalance findBybalanceId(@PathVariable("balanceId")String balanceId) {
        return accountBalanceRepository.findById(balanceId).get();
    }
}
