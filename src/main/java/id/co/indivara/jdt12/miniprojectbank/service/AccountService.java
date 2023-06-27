package id.co.indivara.jdt12.miniprojectbank.service;
import id.co.indivara.jdt12.miniprojectbank.entity.Account;
import id.co.indivara.jdt12.miniprojectbank.entity.AccountBalance;
import id.co.indivara.jdt12.miniprojectbank.entity.AccountTransaction;
import id.co.indivara.jdt12.miniprojectbank.entity.Customer;
import id.co.indivara.jdt12.miniprojectbank.model.HistoryTransaction;
import id.co.indivara.jdt12.miniprojectbank.model.SaveAccount;
import id.co.indivara.jdt12.miniprojectbank.repository.AccountBalanceRepository;
import id.co.indivara.jdt12.miniprojectbank.repository.AccountRepository;
import id.co.indivara.jdt12.miniprojectbank.repository.AccountTransactionRepository;
import id.co.indivara.jdt12.miniprojectbank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountBalanceRepository accountBalanceRepository;

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    AccountTransactionRepository accountTransactionRepository;

    public List<Account> getAllAccount(){
        return (List<Account>) accountRepository.findAll();
    }

    public Boolean saveAccount(SaveAccount saveAccount){
        Customer customer = customerRepository.findById(saveAccount.getCustomerId()).get();

        if (customer != null){
            Account act = accountRepository.save(Account.builder().
                    accountNumber(saveAccount.getAccountNumber()).
                    customerId(customer.getCustomerId()). //ditambahin
                    customer(customer).
                    pin(String.valueOf(saveAccount.getPin())).
                    build());
            AccountBalance accountBalance = new AccountBalance();
            //masalah
            accountBalance.setAccountId(act.getAccountId());
            accountBalance.setAccount(act); //customerId ga masuk
            accountBalance.setBalance(BigDecimal.ZERO);
            accountBalanceRepository.save(accountBalance);
            return true;
        }
        return false;
    }

    //history transaksi
    public HistoryTransaction historyTransaction(String accountId) throws NoSuchElementException { //exception: exception biasa //NoSuchElementException: objek pelanggan
        Account account = accountRepository.findById(accountId)
                .orElseThrow(()-> new NoSuchElementException("akun tidak ditemukan"));
        List<AccountTransaction> accountTransactions = accountTransactionRepository.findAllByAccount(account);
        return new HistoryTransaction(account, accountTransactions);
    }
}
