package com.example.codeclan.courseBooking.repositories;

import com.example.codeclan.courseBooking.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByBookingsCourseName(String name);
    List<Customer> findByTownAndBookingsCourseName(String town, String name);
    List<Customer> findByAgeGreaterThanAndTownAndBookingsCourseName(int age, String town, String name);

}
