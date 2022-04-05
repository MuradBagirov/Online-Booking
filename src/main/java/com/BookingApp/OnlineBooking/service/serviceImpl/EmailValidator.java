package com.BookingApp.OnlineBooking.service.serviceImpl;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class EmailValidator implements Predicate<String> {
    @Override
    public boolean test(String test) {
        return true;
    }
}
