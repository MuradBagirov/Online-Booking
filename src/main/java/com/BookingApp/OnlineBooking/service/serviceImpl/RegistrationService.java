package com.BookingApp.OnlineBooking.service.serviceImpl;


import com.BookingApp.OnlineBooking.dto.RegistrationRequest;
import com.BookingApp.OnlineBooking.model.AppUser;
import com.BookingApp.OnlineBooking.model.AppUserRole;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;
    private final EmailValidator emailValidator;

    public String register(RegistrationRequest registrationRequest){

        boolean isValidEmail=emailValidator.test(registrationRequest.getEmail());

        if (!isValidEmail){
            throw new IllegalStateException("Email not valid");
        }
        appUserService.signUpUser( new AppUser(
                registrationRequest.getName(),
                registrationRequest.getLastname(),
                registrationRequest.getEmail(),
                registrationRequest.getPassword(),
                AppUserRole.USER

        ));
        return "Done";
    }

}
