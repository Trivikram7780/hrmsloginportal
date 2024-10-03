package com.vikram.hrmsloginportl.service;

import com.vikram.hrmsloginportl.Entity.Usersdata;
import com.vikram.hrmsloginportl.dto.UserPrincipal;
import com.vikram.hrmsloginportl.repository.MyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private MyRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Usersdata user = repo.findByUsername(username);
       if(user == null){
           System.out.println("No user");
           throw new UsernameNotFoundException("No users found");
       }

       return new UserPrincipal(user);


    }
}
