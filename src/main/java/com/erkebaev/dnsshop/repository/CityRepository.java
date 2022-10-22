package com.erkebaev.dnsshop.repository;

import com.erkebaev.dnsshop.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}
