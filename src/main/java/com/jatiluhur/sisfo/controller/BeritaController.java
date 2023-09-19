package com.jatiluhur.sisfo.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jatiluhur.sisfo.model.Berita;
import com.jatiluhur.sisfo.service.BeritaService;

@RestController
@RequestMapping("/api/berita")
public class BeritaController {
    
    private BeritaService beritaService;

    @GetMapping("/get")
    public ResponseEntity<Object> findAll(HttpServletRequest request)
    {
        return beritaService.findAll(request);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Berita> getBeritaById(@PathVariable Long id){
        Optional<Berita> berita = beritaService.getBeritaById(id);
        return berita.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
