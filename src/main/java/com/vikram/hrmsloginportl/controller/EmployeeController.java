package com.vikram.hrmsloginportl.controller;


import com.vikram.hrmsloginportl.Entity.Usersdata;
import com.vikram.hrmsloginportl.dto.TokenDto;
import com.vikram.hrmsloginportl.service.JWTService;
import com.vikram.hrmsloginportl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private UserService userService;

    @Autowired
    private JWTService jwtService;





    @PostMapping("/register")
    public Usersdata registerUser(@RequestBody Usersdata user){
         return userService.saveInDb(user);
    }

    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<TokenDto> login(@RequestBody Usersdata user){
        boolean isValidUser = userService.verify(user);
        if(isValidUser)
        {
            return ResponseEntity.ok(new TokenDto(true , jwtService.generateToken(user.getUsername())));
        }
        else{
            System.out.println("Not valid");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new TokenDto(false, "not valid"));
        }

    }
}
