package com.maplemegan.cozycuppa.springsecurity;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import com.maplemegan.cozycuppa.repositories.UserRepository;


@Service
public class SecurityUserDetailsService implements UserDetailsService { 
	@Autowired
    private UserRepository userRepository;
     
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        com.maplemegan.cozycuppa.entities.User user = userRepository.findByuserName(username);
         
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
         
        return new MyUserDetails(user);
    }


}
