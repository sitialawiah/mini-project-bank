package id.co.indivara.jdt12.miniprojectbank.service;
import id.co.indivara.jdt12.miniprojectbank.entity.Account;
import id.co.indivara.jdt12.miniprojectbank.entity.Customer;
import id.co.indivara.jdt12.miniprojectbank.model.CustomerInfo;
import id.co.indivara.jdt12.miniprojectbank.repository.AccountRepository;
import id.co.indivara.jdt12.miniprojectbank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AccountRepository accountRepository;

    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }
    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    //mandatory customer statemen
    public CustomerInfo detailCustomer(String customerId) throws Exception{
        Customer customer = customerRepository.findById(customerId).orElseThrow(()-> new Exception("Customer Error"));
        List<Account>  accounts = accountRepository.findAllByCustomer(customer);
        return new CustomerInfo(customer, accounts);
    }
}