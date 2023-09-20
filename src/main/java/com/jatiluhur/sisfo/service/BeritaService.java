package com.jatiluhur.sisfo.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jatiluhur.sisfo.handler.ResponseHandler;
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

    public ResponseEntity<Object> getById(Long id, HttpServletRequest request) {
        Optional<Berita> berita = beritaRepo.findById(id);
        HttpStatus status;
        String message;

        if (berita.isPresent()) {
            status = HttpStatus.OK;
            message = "Data dengan ID " + id + " berhasil ditemukan";
        } else {
            status = HttpStatus.NOT_FOUND;
            message = "Data dengan ID " + id + " tidak Ditemukan";
        }

         return new ResponseEntity<>(berita, status);
    }

    public ResponseEntity<Object> delete(Long id, HttpServletRequest request) {
        HttpStatus status;
        String message;

        try {
            beritaRepo.deleteById(id);
            status = HttpStatus.NO_CONTENT;
            message = "Data dengan ID " + id + " berhasil dihapus";
        } catch (Exception e) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            message = "Gagal menghapus data dengan ID " + id;
        }

        return new ResponseHandler().generateResponse(message, status, null, null, request);
    }

    public ResponseEntity<Object> save(Berita berita, HttpServletRequest request) {
        try {
            Berita savedBerita = beritaRepo.save(berita);
            HttpStatus status = HttpStatus.CREATED;
            String message = "Data berhasil disimpan";
            return new ResponseHandler().generateResponse(message, status, savedBerita, null, request);
        } catch (Exception e) {
            HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
            String message = "Gagal menyimpan data";
            return new ResponseHandler().generateResponse(message, status, null, null, request);
        }
    }

    public ResponseEntity<Object> update(Long id, Berita updatedBerita, HttpServletRequest request) {
        try {
            Optional<Berita> existingBerita = beritaRepo.findById(id);
            if (existingBerita.isPresent()) {
                Berita berita = existingBerita.get();
                berita.setNik(updatedBerita.getNik());
                berita.setPost(updatedBerita.getPost());
                berita.setUrl(updatedBerita.getUrl());
                Berita updated = beritaRepo.save(berita);

                HttpStatus status = HttpStatus.OK;
                String message = "Data berhasil diperbarui";
                return new ResponseHandler().generateResponse(message, status, updated, null, request);
            } else {
                HttpStatus status = HttpStatus.NOT_FOUND;
                String message = "Data dengan ID " + id + " tidak Ditemukan";
                return new ResponseHandler().generateResponse(message, status, null, null, request);
            }
        } catch (Exception e) {
            HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
            String message = "Gagal memperbarui data";
            return new ResponseHandler().generateResponse(message, status, null, null, request);
        }
    }
    
}
