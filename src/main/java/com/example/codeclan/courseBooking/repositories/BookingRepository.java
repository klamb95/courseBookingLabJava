package com.example.codeclan.courseBooking.repositories;

import com.example.codeclan.courseBooking.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
