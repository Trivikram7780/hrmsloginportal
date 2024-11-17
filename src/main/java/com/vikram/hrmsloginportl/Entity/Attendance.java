package com.vikram.hrmsloginportl.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userid;

    @Column(nullable = false)
    private LocalDateTime checkin;

    private LocalDateTime checkout;
}