package com.example.student.config;

import com.example.student.repository.UserRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author nilambar
 */
@Component
public class MyUserDetailsServiceImpl implements MyUserDetailsService {

    @Autowired
    UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<com.example.student.model.UserDetails> userDetails = userRepo.findByName(name);
        if (!userDetails.isPresent()) {
            throw new UsernameNotFoundException(name);
        }
        return new User(userDetails.get().getName(), userDetails.get().getPassword(), true, true, true, true, new ArrayList<>());
    }

}
