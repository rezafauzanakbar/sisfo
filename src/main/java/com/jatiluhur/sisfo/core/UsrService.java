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
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UsrService<T> {
    public ResponseEntity<Object> save(T t, HttpServletRequest request);//001-010
    public ResponseEntity<Object> update(String nik,T t,HttpServletRequest request) throws Exception;//011-020
    public ResponseEntity<Object> delete(String nik,HttpServletRequest request);//021-030
    public ResponseEntity<Object> saveBatch(List<T> lt, HttpServletRequest request);//031-040
    public ResponseEntity<Object> findById(String nik, HttpServletRequest request);//041-050
    public ResponseEntity<Object> findByPage(Integer page,Integer size, String columFirst,String valueFirst, HttpServletRequest request);//051-060
    public ResponseEntity<Object> findAllByPage(Integer page,Integer size, HttpServletRequest request);//061-070
    public ResponseEntity<Object> findAll(HttpServletRequest request);//071-080
    public ResponseEntity<Object> dataToExport(MultipartFile multipartFile, HttpServletRequest request);//081-090
}
