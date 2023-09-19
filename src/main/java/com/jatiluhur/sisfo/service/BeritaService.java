package com.jatiluhur.sisfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jatiluhur.sisfo.model.Berita;
import com.jatiluhur.sisfo.repo.BeritaRepo;

@Service
public class BeritaService{
    private final BeritaRepo beritaRepo;

    @Autowired
    public BeritaService(BeritaRepo beritaRepo) {
        this.beritaRepo = beritaRepo;
    }

    public ResponseEntity<List<Berita>> findAll() {
        List<Berita> listBerita;
        HttpStatus status;
        String message;

        try {
            listBerita = beritaRepo.findAll();
            if (listBerita.isEmpty()) {
                status = HttpStatus.NOT_FOUND;
                message = "Data tidak Ditemukan";
            } else {
                status = HttpStatus.OK;
                message = "Data berhasil ditemukan";
            }
        } catch (Exception e) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            message = "Data tidak Valid";
            listBerita = null;
        }

        return new ResponseEntity<>(listBerita, status);
    }

}
