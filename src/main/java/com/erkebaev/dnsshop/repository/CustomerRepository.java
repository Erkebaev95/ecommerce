package com.erkebaev.dnsshop.repository;

import com.erkebaev.dnsshop.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
