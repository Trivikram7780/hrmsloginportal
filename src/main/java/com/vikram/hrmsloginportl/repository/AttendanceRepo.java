package com.vikram.hrmsloginportl.repository;

import com.vikram.hrmsloginportl.Entity.Attendance;
;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepo extends JpaRepository<Attendance, Integer> {
}
