package com.vikram.hrmsloginportl.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AttendanceReloadResponse {
    private String todayCheckin;
    private String todayCheckout;
    private List<Double> lastFiveDaysHours;
}
