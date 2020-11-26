package com.harshalmayee.services.impl;

import com.harshalmayee.models.UserPrincipal;
import com.harshalmayee.models.Users;
import com.harshalmayee.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user=userRepository.findByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("User Not Found :"+username);
        }
        return new UserPrincipal(user);
    }
}
