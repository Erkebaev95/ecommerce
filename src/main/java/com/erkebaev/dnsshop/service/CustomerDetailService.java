package com.erkebaev.dnsshop.service;

import com.erkebaev.dnsshop.model.Customer;
import com.erkebaev.dnsshop.repository.CustomerRepository;
import com.erkebaev.dnsshop.security.CustomerDetailImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerDetailService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerDetailService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s)
            throws UsernameNotFoundException {

        Customer customer = customerRepository.findByLogin(s);

        if (customer == null)
            throw new UsernameNotFoundException("User not found!");

        return new CustomerDetailImpl(customer);
    }
}
