package com.jatiluhur.sisfo.controller;
/*
IntelliJ IDEA 2023.2.1 (Community Edition)
Build #IC-232.9559.62, built on August 23, 2023
@Author user a.k.a. Reza Fauzan Akbar
Java Developer
Created on 19/09/2023 11:43
@Last Modified 19/09/2023 11:43
Version 1.0
*/

import com.jatiluhur.sisfo.dto.UserDTO;
import com.jatiluhur.sisfo.model.User;
import com.jatiluhur.sisfo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private ModelMapper modelMapper;

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/v1/login")
    public ResponseEntity<Object> getToken(@RequestBody UserDTO userDTO, HttpServletRequest request) throws Exception{

        return userService.authManager(userDTO,request);
    }

    @PostMapping("/v1/regis")
    public ResponseEntity<Object> save(@RequestBody UserDTO userDTO, HttpServletRequest request)
    {

        User user = modelMapper.map(userDTO, new TypeToken<User>() {}.getType());;
        return userService.save(user,request);
    }


}
