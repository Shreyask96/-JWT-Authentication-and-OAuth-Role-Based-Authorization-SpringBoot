package com.dakrsolutions.JWT_OAuth.Service;

import java.util.Collection;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dakrsolutions.JWT_OAuth.Entity.User;
import com.dakrsolutions.JWT_OAuth.Models.ReponseModel;
import com.dakrsolutions.JWT_OAuth.Models.RequestModel;
import com.dakrsolutions.JWT_OAuth.Repository.UserRepository;
import com.dakrsolutions.JWT_OAuth.Utilities.JwtUtil;

@Service
public class AuthenticationService implements UserDetailsService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationService(UserRepository userRepository, JwtUtil jwtUtil, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), 
        		                                   (Collection<? extends GrantedAuthority>) user.getRoles());
    }

    public ReponseModel authenticate(RequestModel jwtRequest) throws Exception {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
        } catch (Exception e) {
            throw new Exception("Invalid credentials", e);
        }

        UserDetails userDetails = loadUserByUsername(jwtRequest.getUsername());
        String token = jwtUtil.generateToken(userDetails.getUsername());

        return new ReponseModel(token);
    }
}
