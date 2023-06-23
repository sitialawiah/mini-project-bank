package id.co.indivara.jdt12.miniprojectbank.controller;
import id.co.indivara.jdt12.miniprojectbank.entity.AccountTransaction;
import id.co.indivara.jdt12.miniprojectbank.service.AccountTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class AccountTransactionController {
        @Autowired
        AccountTransactionService accountTransactionService;

        @PostMapping("/savedeposit")
        public AccountTransaction saveAccountTransaction(@RequestBody AccountTransaction accountTransaction) throws Exception{
            return accountTransactionService.createDeposit(accountTransaction);
        }

        @PostMapping("/savewithdraw")
        public AccountTransaction saveWithdraw(@RequestBody AccountTransaction accountTransaction) throws Exception{
            return accountTransactionService.createWithdraw(accountTransaction);
        }

        @PostMapping("/savetransfer")
        public AccountTransaction saveTransfer(@RequestBody AccountTransaction accountTransaction) throws Exception{
        return accountTransactionService.createTransfer(accountTransaction);
        }

        @GetMapping("/accounttransaction")
        public List<AccountTransaction> getAllAccountTransaction(){
            return accountTransactionService.getAllAccountTransaction();
        }
}
