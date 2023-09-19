package com.jatiluhur.sisfo.controller;

import com.jatiluhur.sisfo.model.Kip;
import com.jatiluhur.sisfo.service.KipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/kip")
public class KipController {
    private KipService kipService;

    @Autowired
    public KipController(KipService kipService){
        this.kipService = kipService;
    }

    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody Kip kip, HttpServletRequest request){
        return kipService.save(kip, request);
    }

    @GetMapping("/findall")
    public ResponseEntity<Object> findAll(HttpServletRequest request){
        return kipService.findAll(request);
    }
}
