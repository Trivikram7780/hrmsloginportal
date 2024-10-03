package com.vikram.hrmsloginportl.service;

import com.vikram.hrmsloginportl.Entity.Usersdata;
import com.vikram.hrmsloginportl.repository.MyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private MyRepo repo;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

    public Usersdata saveInDb(Usersdata user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return repo.save(user);
    }

    public String verify(Usersdata user) {

      System.out.println(user.getUsername());
      Authentication authentication =
              authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));

      System.out.println(user.getUsername());

      if(authentication.isAuthenticated())
          return jwtService.generateToken(user.getUsername());

      return "Fail";
    }
}
