package com.example.codeclan.courseBooking.controllers;

import com.example.codeclan.courseBooking.models.Booking;
import com.example.codeclan.courseBooking.models.Customer;
import com.example.codeclan.courseBooking.repositories.BookingRepository;
import com.example.codeclan.courseBooking.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity getAllCustomerByAllMethods(
            @RequestParam(required = false, name = "name") String name,
            @RequestParam(required = false, name = "town") String town,
            @RequestParam(required = false, name = "age") Integer age
    ) {
        if (age!=null && town!=null && name!=null){
            return new ResponseEntity(customerRepository.findByAgeGreaterThanAndTownAndBookingsCourseName(age, town, name), HttpStatus.OK);
        }
        if (town != null && name != null){
            return new ResponseEntity(customerRepository.findByTownAndBookingsCourseName(town, name), HttpStatus.OK);
        }
        if (name != null){
            return new ResponseEntity(customerRepository.findByBookingsCourseName(name), HttpStatus.OK);
        }
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);

    }


    @GetMapping(value = "/customers/{id}")
    public ResponseEntity getCustomer(@PathVariable Long id) {
        return new ResponseEntity<>(customerRepository.findById(id), HttpStatus.OK);
    }

}