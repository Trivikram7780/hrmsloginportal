package com.vikram.hrmsloginportl.repository;

import com.vikram.hrmsloginportl.Entity.Usersdata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyRepo extends JpaRepository<Usersdata, Integer> {
   Usersdata findByUsername(String username);
}
