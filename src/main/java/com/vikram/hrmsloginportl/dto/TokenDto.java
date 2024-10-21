package com.vikram.hrmsloginportl.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TokenDto {
    private boolean isValid;
    private String token;
}
