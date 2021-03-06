package com.BookingApp.OnlineBooking.service.serviceImpl;

import com.BookingApp.OnlineBooking.model.AppUser;
import com.BookingApp.OnlineBooking.repository.AppUserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    private static final String USER_NOT_FOUND_MSG = "user with this email %s not found";
    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException(
                String.format(USER_NOT_FOUND_MSG,email)
        ));
    }

    public String signUpUser(AppUser appUser){
        boolean userExist = appUserRepository.findByEmail(appUser.getEmail()).isPresent();
        if (userExist){
            throw new IllegalStateException("Email already taken");
        }
        String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());
        appUser.setPassword(encodedPassword);
        appUserRepository.save(appUser);
        return " successful";
    }

}
