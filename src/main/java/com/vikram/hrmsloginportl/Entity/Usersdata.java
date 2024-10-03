package com.vikram.hrmsloginportl.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Usersdata {
    @Id
    private int id;
    private String username;
    private String password;
}
