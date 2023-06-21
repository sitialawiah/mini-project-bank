package id.co.indivara.jdt12.miniprojectbank.controller;
import id.co.indivara.jdt12.miniprojectbank.entity.Customer;
import id.co.indivara.jdt12.miniprojectbank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/customer")
    public List<Customer> getAllCustomer(){
        return customerService.getAllCustomer();
    }
}