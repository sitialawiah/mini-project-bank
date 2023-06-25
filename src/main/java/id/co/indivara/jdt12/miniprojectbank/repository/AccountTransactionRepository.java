package id.co.indivara.jdt12.miniprojectbank.repository;
import id.co.indivara.jdt12.miniprojectbank.entity.Account;
import id.co.indivara.jdt12.miniprojectbank.entity.AccountTransaction;
import id.co.indivara.jdt12.miniprojectbank.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction,String> {
//    List<Account> findAllByAccountTransaction(Customer customer);
}
