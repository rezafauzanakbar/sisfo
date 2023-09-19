package com.jatiluhur.sisfo.service;
/*
IntelliJ IDEA 2023.2.1 (Community Edition)
Build #IC-232.9559.62, built on August 23, 2023
@Author user a.k.a. Reza Fauzan Akbar
Java Developer
Created on 19/09/2023 11:31
@Last Modified 19/09/2023 11:31
Version 1.0
*/

import com.jatiluhur.sisfo.core.IService;
import com.jatiluhur.sisfo.handler.ResponseHandler;
import com.jatiluhur.sisfo.model.User;
import com.jatiluhur.sisfo.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class UserService implements IService<User> {

    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public ResponseEntity<Object> save(User user, HttpServletRequest request) {
        if(user==null)
        {
            return new ResponseHandler().generateResponse(
                    "Data tidak Valid",//message
                    HttpStatus.BAD_REQUEST,//httpstatus
                    null,//object
                    "FV002001",//errorCode Fail Validation modul-code 001 sequence 001 range 001 - 010
                    request
            );
        }

        try{
            userRepo.save(user);

        }catch (Exception e)
        {
            return new ResponseHandler().generateResponse(
                    "Data Gagal Disimpan",//message
                    HttpStatus.INTERNAL_SERVER_ERROR,//httpstatus
                    null,//object
                    "FE002001",//errorCode Fail Error modul-code 001 sequence 001 range 001 - 010
                    request
            );
        }

        return new ResponseHandler().generateResponse(
                "Data Berhasil Disimpan",//message
                HttpStatus.CREATED,//httpstatus created
                null,//object
                null,//errorCode diisi null ketika data berhasil disimpan
                request
        );
    }

    @Override
    public ResponseEntity<Object> update(Long id, User user, HttpServletRequest request) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<Object> delete(Long id, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Object> saveBatch(List<User> lt, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Object> findById(Long id, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Object> findByPage(Integer page, Integer size, String columFirst, String valueFirst, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Object> findAllByPage(Integer page, Integer size, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Object> findAll(HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Object> dataToExport(MultipartFile multipartFile, HttpServletRequest request) {
        return null;
    }
}
