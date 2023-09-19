package com.jatiluhur.sisfo.core;
/*
IntelliJ IDEA 2023.2.1 (Community Edition)
Build #IC-232.9559.62, built on August 23, 2023
@Author user a.k.a. Reza Fauzan Akbar
Java Developer
Created on 19/09/2023 13:23
@Last Modified 19/09/2023 13:23
Version 1.0
*/

import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

public interface UsrService<T> {
    public ResponseEntity<Object> registrationUser(T t, HttpServletRequest request);//001-010
}
