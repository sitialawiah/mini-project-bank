package id.co.indivara.jdt12.miniprojectbank.repository;
import id.co.indivara.jdt12.miniprojectbank.entity.Account;
import id.co.indivara.jdt12.miniprojectbank.entity.AccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction,String> {
    List<AccountTransaction>findAllByAccount (Account account);
}