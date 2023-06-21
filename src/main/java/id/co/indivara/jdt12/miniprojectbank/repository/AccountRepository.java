package id.co.indivara.jdt12.miniprojectbank.repository;
import id.co.indivara.jdt12.miniprojectbank.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
}
