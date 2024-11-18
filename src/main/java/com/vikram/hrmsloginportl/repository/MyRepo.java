package com.vikram.hrmsloginportl.repository;

import com.vikram.hrmsloginportl.Entity.Attendance;
import com.vikram.hrmsloginportl.Entity.Usersdata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

@Repository
public interface MyRepo extends JpaRepository<Usersdata, Integer> {
   Usersdata findByUsername(String username);

}
