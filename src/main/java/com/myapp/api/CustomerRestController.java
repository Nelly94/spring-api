package com.myapp.api;

import com.myapp.dao.CustomerRepository;
import com.myapp.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@RequestMapping("/customer")
public class CustomerRestController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/add")
    public Customer add(@RequestBody Customer customer){
        return customerRepository.save(customer);
    }
}
