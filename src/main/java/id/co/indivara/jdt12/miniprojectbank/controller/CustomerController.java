package id.co.indivara.jdt12.miniprojectbank.controller;
import id.co.indivara.jdt12.miniprojectbank.entity.Customer;
import id.co.indivara.jdt12.miniprojectbank.model.CustomerInfo;
import id.co.indivara.jdt12.miniprojectbank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

@PostMapping("/savecustomer")
public Customer saveCustomer(@RequestBody Customer customer){
        return customerService.saveCustomer(customer);
        }

@GetMapping("/customer")
public List<Customer> getAllCustomer(){
        return customerService.getAllCustomer();
        }

    //get account statement
    @GetMapping("/cutomer/{customerId}")
    public CustomerInfo getCustomerById(@PathVariable("customerId") String id)throws Exception{
        return customerService.detailCustomer(id);
    }
}
