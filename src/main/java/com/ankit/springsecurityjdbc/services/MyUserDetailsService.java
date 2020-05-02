package com.ankit.springsecurityjdbc.services;

import com.ankit.springsecurityjdbc.models.MyUserDetails;
import com.ankit.springsecurityjdbc.models.User;
import com.ankit.springsecurityjdbc.repositories.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = userDetailsRepository.findByUserName(s);

        user.orElseThrow(() -> new UsernameNotFoundException("User not found : "+s));

        return user.map(MyUserDetails::new).get();
    }

    @PostConstruct
    public void init(){
        List<User> users = userDetailsRepository.saveAll(getUser());
        System.out.println("After Inserting...");
        users.forEach(System.out::println);
    }

    private List<User> getUser(){
        User user1 = new User();
        user1.setUserName("ankit");
        user1.setPassword("pass");
        user1.setActive(true);
        user1.setAuthorities("ROLE_USER,ROLE_ADMIN");

        User user2 = new User();
        user2.setUserName("bhawar");
        user2.setPassword("password");
        user2.setActive(true);
        user2.setAuthorities("ROLE_USER");

        return Arrays.asList(user1, user2);
    }
}
