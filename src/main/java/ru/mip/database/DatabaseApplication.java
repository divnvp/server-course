package ru.mip.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.mip.database.repositories.UserRepository;

@SpringBootApplication
public class DatabaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(DatabaseApplication.class, args);
    }

    @Autowired
    private void authenticationManager(AuthenticationManagerBuilder builder, UserRepository userRepository){
        try {
            builder.userDetailsService(s -> new CustomUserDetails(userRepository.findByUsername(s)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
