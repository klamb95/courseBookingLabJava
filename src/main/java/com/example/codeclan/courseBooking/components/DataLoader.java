package com.example.codeclan.courseBooking.components;

import com.example.codeclan.courseBooking.models.Booking;
import com.example.codeclan.courseBooking.models.Course;
import com.example.codeclan.courseBooking.models.Customer;
import com.example.codeclan.courseBooking.repositories.BookingRepository;
import com.example.codeclan.courseBooking.repositories.CourseRepository;
import com.example.codeclan.courseBooking.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.awt.print.Book;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args){
        Course course1 = new Course("Intro to Python", "Edinburgh", 5 );
        courseRepository.save(course1);

        Course course2 = new Course("Intro to JS", "Glasgow", 3);
        courseRepository.save(course2);

        Course course3 = new Course("Intro to Java", "Dubai", 4);
        courseRepository.save(course3);

        Customer kieran = new Customer("Kieran", "Livingston", 25);
        customerRepository.save(kieran);

        Customer aidan = new Customer("Aidan", "Livingston", 21);
        customerRepository.save(aidan);

        Customer giuliano = new Customer("Giuliano", "Glasgow", 28);
        customerRepository.save(giuliano);

        Customer colin = new Customer("Colin", "Bathgate ", 34);
        customerRepository.save(colin);

        Booking booking1 = new Booking("21/04/2021", course1, kieran);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("03/05/2020", course2, giuliano);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking("04/09/2019", course3, colin);
        bookingRepository.save(booking3);

        Booking booking4 = new Booking("12/07/1995", course2, kieran);
        bookingRepository.save(booking4);

        Booking booking5 = new Booking("13/06/2020", course2, aidan);
        bookingRepository.save(booking5);
    }
}
