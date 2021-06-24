package com.example.codeclan.courseBooking.repositories;

import com.example.codeclan.courseBooking.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByBookingsCourseNameIgnoreCase(String name);
    List<Customer> findByTownAndBookingsCourseNameIgnoreCase(String town, String name);
    List<Customer> findByAgeGreaterThanAndTownAndBookingsCourseNameIgnoreCase(int age, String town, String name);

}
