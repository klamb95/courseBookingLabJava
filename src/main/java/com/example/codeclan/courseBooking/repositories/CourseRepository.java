package com.example.codeclan.courseBooking.repositories;

import com.example.codeclan.courseBooking.models.Course;
import com.example.codeclan.courseBooking.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByRatingIgnoreCase(int rating);
    List<Course> findByBookingsCustomerNameIgnoreCase(String name);
}
