package id.co.indivara.jdt12.miniprojectbank.model;
import id.co.indivara.jdt12.miniprojectbank.entity.Account;
import id.co.indivara.jdt12.miniprojectbank.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
@Data
@AllArgsConstructor
public class CustomerInfo {
    private Customer customer;
    private List<Account> accounts;
}
