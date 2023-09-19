package com.jatiluhur.sisfo.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "MstKip")
public class Kip {
    @Id
    @Column(name="Nik")
    private long nik;

    @Column(name ="nama")
    private String nama;

    @Column(name = "TanggalLahir")
    private LocalDate tanggalLahir;

    @Column(name = "Alamat")
    private String alamat;

    @Column(name = "Gender")
    private String gender;

    public long getNik() {
        return nik;
    }

    public void setNik(long nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public LocalDate getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(LocalDate tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
