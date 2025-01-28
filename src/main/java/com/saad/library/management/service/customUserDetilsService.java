package com.saad.library.management.service;

import com.saad.library.management.model.security_User;
import com.saad.library.management.repository.securityUserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class customUserDetilsService implements UserDetailsService {
    @Autowired
    public securityUserRepo SecurityUserRepo;


    @Autowired
    @Lazy
    public  AuthenticationManager authenticationManager;




    private BCryptPasswordEncoder encoder =new BCryptPasswordEncoder(12);



    public security_User userRegister(security_User securityUser){
        securityUser.setPassword(encoder.encode(securityUser.getPassword()));
        return SecurityUserRepo.save(securityUser);
    }
    @Override
    @Transactional // Ensures session is open when fetching user and roles
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        security_User securityUser=SecurityUserRepo.findByUsername(username).
                orElseThrow(()-> new UsernameNotFoundException("user not found" + username));
                return new org.springframework.security.core.userdetails.User(
                        securityUser.getUsername(),
                        securityUser.getPassword(),
                        securityUser.getRoles().stream()
                                .map(role -> new SimpleGrantedAuthority(role.getName()))
                                .collect(Collectors.toList()));

    }

    public String login(security_User securityUser) {
        Optional<security_User> userOptional=SecurityUserRepo.findByUsername(securityUser.getUsername());

        if(userOptional.isEmpty() || !encoder.matches(securityUser.getPassword(),userOptional.get().getPassword())){
            return "Invalid username or password";
        }
        Authentication authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(securityUser.getUsername(), securityUser.getPassword())
        );
        if (authentication.isAuthenticated()){
            return "login successful";
        }
        return "login failed";

    }
}
