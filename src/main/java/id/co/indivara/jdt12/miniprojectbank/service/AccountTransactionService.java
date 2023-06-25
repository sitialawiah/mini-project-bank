package id.co.indivara.jdt12.miniprojectbank.service;
import id.co.indivara.jdt12.miniprojectbank.entity.Account;
import id.co.indivara.jdt12.miniprojectbank.entity.AccountBalance;
import id.co.indivara.jdt12.miniprojectbank.entity.AccountTransaction;
import id.co.indivara.jdt12.miniprojectbank.repository.AccountBalanceRepository;
import id.co.indivara.jdt12.miniprojectbank.repository.AccountRepository;
import id.co.indivara.jdt12.miniprojectbank.repository.AccountTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Service
public class AccountTransactionService {
    @Autowired
    AccountTransactionRepository accountTransactionRepository;

    @Autowired
    AccountBalanceRepository accountBalanceRepository;

    @Autowired
    AccountRepository accountRepository;

    @Transactional
    public AccountTransaction createDeposit (AccountTransaction account)throws Exception {
        Account accountResult = accountRepository.findById(account.getAccountId()).orElseThrow(() -> new Exception("account tidak ditemukan"));
        AccountBalance accountBalance = accountBalanceRepository.findByAccountId(account.getAccountId()).orElseThrow(() -> new Exception("account balance tidak ditemukan"));
        account.setAccount(accountResult);
        account.setTypeTransaction(AccountTransaction.EnumTransaction.DEPOSIT);
        account.setCreatedDate(Instant.now());
        accountTransactionRepository.save(account);

        accountBalance.setBalance(accountBalance.getBalance().add(account.getAmount()));
        accountBalanceRepository.save(accountBalance);
    return accountTransactionRepository.save(account);
    }

    @Transactional
    public AccountTransaction createWithdraw (AccountTransaction account)throws Exception {
        Account accountResult = accountRepository.findById(account.getAccountId()).orElseThrow(() -> new Exception("account tidak ditemukan"));
        AccountBalance accountBalance = accountBalanceRepository.findByAccount(accountResult).orElseThrow(() -> new Exception("account balance tidak ditemukan"));
        BigDecimal moneynotenought= accountBalance.getBalance().subtract(account.getAmount()); //uang kurang
        if (moneynotenought.compareTo(BigDecimal.ZERO)<0){
            throw new Exception("Uang nya ga cukup");
        }
        account.getTypeTransaction(); //type dari transaksi (withdraw)
        account.setAccount(accountResult);
        account.setTypeTransaction(AccountTransaction.EnumTransaction.WITHDRAW);
        account.setCreatedDate(Instant.now());
        accountTransactionRepository.save(account);

        accountBalance.setBalance(moneynotenought);
        accountBalanceRepository.save(accountBalance);
    return accountTransactionRepository.save(account);
    }
    
    @Transactional
    public AccountTransaction createTransfer (AccountTransaction account)throws Exception {
        Account accountResult = accountRepository.findById(account.getAccountId()).orElseThrow(() -> new Exception("account tidak ditemukan"));
        AccountBalance accountBalance = accountBalanceRepository.findByAccount(accountResult).orElseThrow(() -> new Exception("account balance tidak ditemukan"));
        Account accountDestination = accountRepository.findByAccountNumber(account.getAccountNumber()).orElseThrow(()-> new Exception("Tujuannya Tidak Ketemu"));
        AccountBalance accountBalanceDestination = accountBalanceRepository.findByAccount(accountDestination).orElseThrow(()-> new Exception("Balance / Saldo Tujuan Tidak Ada"));

        BigDecimal moneynotenought = accountBalance.getBalance().subtract(account.getAmount()); //uang ga cukup
        if (moneynotenought.compareTo(BigDecimal.ZERO)<0){
            throw new Exception("Uang nya ga cukup");
        }

        BigDecimal moneyDestinationBalance =accountBalanceDestination.getBalance().add(account.getAmount());

        account.setAccount(accountResult);
        account.setTypeTransaction(AccountTransaction.EnumTransaction.TRANSFER);
        account.setCreatedDate(Instant.now());
        accountTransactionRepository.save(account);
        accountBalance.setBalance(accountBalance.getBalance().min(account.getAmount()));

        accountBalanceDestination.setBalance(moneyDestinationBalance);
        accountBalanceRepository.save(accountBalanceDestination);

        accountBalanceRepository.save(accountBalance);
        return accountTransactionRepository.save(account);
    }

    public List<AccountTransaction> getAllAccountTransaction(){
        return (List<AccountTransaction>) accountTransactionRepository.findAll();
    }
}