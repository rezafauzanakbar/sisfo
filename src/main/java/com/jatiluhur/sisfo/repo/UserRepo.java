package com.jatiluhur.sisfo.repo;
/*
IntelliJ IDEA 2023.2.1 (Community Edition)
Build #IC-232.9559.62, built on August 23, 2023
@Author user a.k.a. Reza Fauzan Akbar
Java Developer
Created on 19/09/2023 11:29
@Last Modified 19/09/2023 11:29
Version 1.0
*/

import com.jatiluhur.sisfo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {
    public Optional<User> findByNik(String nik);
    public Optional<User> findByNikAndPassword(String nik, String password);
}
