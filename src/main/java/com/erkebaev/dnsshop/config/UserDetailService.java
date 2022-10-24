package com.erkebaev.dnsshop.config;

import com.erkebaev.dnsshop.model.User;
import com.erkebaev.dnsshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s)
            throws UsernameNotFoundException {

        User user = userRepository.findByLogin(s);

        if (user == null)
            throw new UsernameNotFoundException("User not found!");

        return new UserDetailsImpl(user);
    }
}
