package id.co.indivara.jdt12.miniprojectbank.repository;
import id.co.indivara.jdt12.miniprojectbank.entity.AccountBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
public interface AccountBalanceRepository extends JpaRepository <AccountBalance, String> {

    Optional<AccountBalance> findByAccountId(String accountId);
}
