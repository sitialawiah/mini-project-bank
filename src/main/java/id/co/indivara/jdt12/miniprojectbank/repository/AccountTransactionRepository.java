package id.co.indivara.jdt12.miniprojectbank.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransactionRepository, Integer> {
}
