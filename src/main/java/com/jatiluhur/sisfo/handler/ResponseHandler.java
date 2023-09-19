package com.jatiluhur.sisfo.handler;
/*
IntelliJ IDEA 2023.2.1 (Community Edition)
Build #IC-232.9559.62, built on August 23, 2023
@Author user a.k.a. Reza Fauzan Akbar
Java Developer
Created on 19/09/2023 11:59
@Last Modified 19/09/2023 11:59
Version 1.0
*/

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    public ResponseHandler() {
    }

    public ResponseEntity<Object> generateResponse(String message,
                                                   HttpStatus status,
                                                   Object responseObj,
                                                   Object errorCode,
                                                   HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("status", status.value());
        map.put("data", responseObj==null?"":responseObj);
        map.put("timestamp", new Date());
        map.put("success",!status.isError());
        if(errorCode != null)
        {
            map.put("errorCode",errorCode);
            map.put("path",request.getPathInfo());
        }
        return new ResponseEntity<Object>(map,status);
    }
}
