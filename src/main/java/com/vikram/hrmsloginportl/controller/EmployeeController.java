package com.vikram.hrmsloginportl.controller;


import com.vikram.hrmsloginportl.Entity.Usersdata;
import com.vikram.hrmsloginportl.dto.AttendanceReloadResponse;
import com.vikram.hrmsloginportl.dto.UserDetails;
import com.vikram.hrmsloginportl.service.AttendanceService;
import com.vikram.hrmsloginportl.service.UserService;
import com.vikram.hrmsloginportl.Entity.EmployeeDetails;
import com.vikram.hrmsloginportl.dto.TokenDto;
import com.vikram.hrmsloginportl.service.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    private UserService userService;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private AttendanceService attendanceService;





    @PostMapping("/register")
    public Usersdata registerUser(@RequestBody Usersdata user){
         return userService.saveInDb(user);
    }

    @PostMapping("/login")
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

    @PostMapping("/checkin")
    public String checkIn(@RequestBody UserDetails userDetails) {
        System.out.println(userDetails.getUserId());
        return attendanceService.checkIn(userDetails.getUserId());
    }

    @PostMapping("/checkout")
    public String checkOut(@RequestBody UserDetails userDetails) {
        return attendanceService.checkOut(userDetails.getUserId());
    }

    @PostMapping("/reload")
    public AttendanceReloadResponse reload(@RequestBody UserDetails userDetails){
         return attendanceService.getReloadData(userDetails.getUserId());
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/reload", method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> handlePreflight() {
        // Respond to the preflight OPTIONS request
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/profile")
    public EmployeeDetails profile(@RequestBody UserDetails userDetails){
        return attendanceService.getProfileByName(userDetails.getUserId());
    }
}
