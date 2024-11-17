package com.vikram.hrmsloginportl.repository;

import com.vikram.hrmsloginportl.Entity.Attendance;
import com.vikram.hrmsloginportl.Entity.Usersdata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.time.LocalDate;

@Repository
public interface MyRepo extends JpaRepository<Usersdata, Integer> {
   Usersdata findByUsername(String username);


   @Query("SELECT a FROM Attendance a WHERE a.userid = :userid AND DATE(a.checkin) = :date")
   Optional<Attendance> findByUsernameAndDate(String userid, LocalDate date);
}
