package id.co.indivara.jdt12.miniprojectbank.service;
import id.co.indivara.jdt12.miniprojectbank.entity.Customer;
import id.co.indivara.jdt12.miniprojectbank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository accountRepository;
    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    public String createAccount(Customer account) {
        Customer cst = accountRepository.save(account);
        if (Objects.nonNull(cst) && cst.getCustomerId() != null) {
            return "Account " + cst.getCustomerId() + " Berhasil Dibuat";
        } else {
            return "Gagal Insert Customer";
        }
    }
}
