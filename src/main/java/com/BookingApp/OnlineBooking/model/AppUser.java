package com.BookingApp.OnlineBooking.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.modelmapper.Converters;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class AppUser implements UserDetails {

    @Id
    @SequenceGenerator(name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "user_sequence")
    Long id;

    String name;
    String lastname;
    String email;
    String password;

    @Enumerated(EnumType.STRING)
    AppUserRole appUserRole;

    Boolean locked = false;
    Boolean enable =true;

    public AppUser(String name, String lastname, String email, String password, AppUserRole appUserRole) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.appUserRole = appUserRole;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority =
                new SimpleGrantedAuthority(appUserRole.name());
        return Collections.singleton(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enable;
    }
}
