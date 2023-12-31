package com.jatiluhur.sisfo.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Kip")
public class Kip {
    @Id
    @Column(name="Nik")
    private Long nik;

    @Column(name ="nama")
    private String nama;

    @Column(name = "TanggalLahir")
    private Date tanggalLahir;

    @Column(name = "Alamat")
    private String alamat;

    @Column(name = "Gender")
    private String gender;

    public Long getNik() {
        return nik;
    }

    public void setNik(Long nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
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
