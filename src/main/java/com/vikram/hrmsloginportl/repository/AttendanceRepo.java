package com.vikram.hrmsloginportl.repository;

import com.vikram.hrmsloginportl.Entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AttendanceRepo extends JpaRepository<Attendance, Integer> {
    @Query("SELECT a FROM Attendance a WHERE a.userid = :userid AND DATE(a.checkin) = :date")
    Optional<Attendance> findByUsernameAndDate(String userid, LocalDate date);

    @Query("SELECT a FROM Attendance a WHERE a.userid = :userid AND DATE(a.checkin) BETWEEN :startDate AND :endDate")
    List<Attendance> findRecordsBetweenDates(String userid, LocalDate startDate, LocalDate endDate);

    @Query("""
    SELECT 
        DATE(a.checkin) AS day, 
        COALESCE(SUM(TIMESTAMPDIFF(MINUTE, a.checkin, a.checkout)) / 60.0, 0) AS hoursWorked
    FROM 
        Attendance a
    WHERE 
        a.userid = :userid 
        AND DATE(a.checkin) BETWEEN :startDate AND :endDate
    GROUP BY 
        DATE(a.checkin)
    ORDER BY 
        DATE(a.checkin)
""")
    List<Object[]> calculateHoursForLastFiveDays(
            @Param("userid") String userid,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );
}
