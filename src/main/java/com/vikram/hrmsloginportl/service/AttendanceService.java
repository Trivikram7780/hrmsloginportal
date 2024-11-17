package com.vikram.hrmsloginportl.service;


import com.vikram.hrmsloginportl.Entity.Attendance;
import com.vikram.hrmsloginportl.repository.AttendanceRepo;
import com.vikram.hrmsloginportl.repository.MyRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AttendanceService {

    @Autowired
    private MyRepo myRepo;

    @Autowired
    private AttendanceRepo attendanceRepo;

    @Transactional
    public String checkIn(String userid){
        LocalDate today = LocalDate.now();
        System.out.println(userid);
        Optional<Attendance> existing = myRepo.findByUsernameAndDate(userid, today);
        if (existing.isPresent()) {
            return "User has already checked in today.";
        }
        else{
            Attendance attendance = new Attendance();
            attendance.setUserid(userid);
            attendance.setCheckin(LocalDateTime.now());
            attendance.setCheckout(null);

            attendanceRepo.save(attendance);
        }
        return  "ok";
    }

    @Transactional
    public String checkOut(String username){
        LocalDate today = LocalDate.now();
        Optional<Attendance> existing = myRepo.findByUsernameAndDate(username, today);
        if (existing.isEmpty()) {
            return "No check-in found for today.";
        }

        Attendance attendance = existing.get();
        if (attendance.getCheckout() != null) {
            return "User has already checked out today.";
        }

        attendance.setCheckout(LocalDateTime.now());
        attendanceRepo.save(attendance);
        return "Check-out successful.";
    }

}