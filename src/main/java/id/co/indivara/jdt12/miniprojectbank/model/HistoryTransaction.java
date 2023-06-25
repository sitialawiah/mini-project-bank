package id.co.indivara.jdt12.miniprojectbank.model;
import id.co.indivara.jdt12.miniprojectbank.entity.Account;
import id.co.indivara.jdt12.miniprojectbank.entity.AccountTransaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class HistoryTransaction {
    private Account account;
    private List<AccountTransaction> accountTransactionList;
}
