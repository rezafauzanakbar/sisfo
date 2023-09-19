package com.jatiluhur.sisfo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jatiluhur.sisfo.model.Berita;
import com.jatiluhur.sisfo.repo.BeritaRepo;

@Service
public class BeritaService {
    private final BeritaRepo beritaRepo;

    @Autowired
    public BeritaService(BeritaRepo beritaRepo) {
        this.beritaRepo = beritaRepo;
    }

    public List<Berita> getAllBerita() {
        return (List<Berita>) beritaRepo.findAll();
    }

    public Optional<Berita> getBeritaById(Long id) {
        return beritaRepo.findById(id);
    }

    public Berita createBerita(Berita berita) {
        return beritaRepo.save(berita);
    }

    public Berita updateBerita(Long id, Berita updatedBerita) {
        Optional<Berita> existingBerita = beritaRepo.findById(id);
        if (existingBerita.isPresent()) {
            Berita berita = existingBerita.get();
            berita.setNik(updatedBerita.getNik());
            berita.setPost(updatedBerita.getPost());
            berita.setUrl(updatedBerita.getUrl());
            return beritaRepo.save(berita);
        } else {
            throw new RuntimeException("Berita not found with id: " + id);
        }
    }

    public void deleteBerita(Long id) {
        beritaRepo.deleteById(id);
    }

}
