package com.BookingApp.OnlineBooking.repository;

import com.BookingApp.OnlineBooking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

