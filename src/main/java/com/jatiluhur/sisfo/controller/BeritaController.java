package com.jatiluhur.sisfo.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jatiluhur.sisfo.model.Berita;
import com.jatiluhur.sisfo.service.BeritaService;

@RestController
@RequestMapping("/api/berita")
public class BeritaController {

    private final BeritaService beritaService;

    @Autowired
    public BeritaController(BeritaService beritaService) {
        this.beritaService = beritaService;
    }


    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody Berita berita, HttpServletRequest request) {
        return beritaService.save(berita, request);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Berita updatedBerita, HttpServletRequest request) {
        return beritaService.update(id, updatedBerita, request);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Berita>> findAll(HttpServletRequest request) {
        return beritaService.findAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id, HttpServletRequest request) {
        return beritaService.getById(id, request);
    }

     @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id, HttpServletRequest request) {
        return beritaService.delete(id, request);
    }
}
