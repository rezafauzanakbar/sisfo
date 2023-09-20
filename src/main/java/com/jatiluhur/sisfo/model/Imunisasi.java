package com.jatiluhur.sisfo.model;

import javax.persistence.*;

import java.util.Date;
@Entity
@Table(name = "Imunisasi")
public class Imunisasi    {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDImunisasi")
    private Long idImunisasi;


     @Column(name = "Status")
    private String status;

    @Column(name = "TanggalImunisasi",columnDefinition = "DATETIME NOT NULL default GETDATE()")
    private Date tanggalImunisasi= new Date();

    @Column(name = "Lokasi")
    private String lokasi;

    public Long getIdImunisasi() {
        return idImunisasi;
    }

    public void setIdImunisasi(Long idImunisasi) {
        this.idImunisasi = idImunisasi;
    }

    public String getStatus() {
        return status;  
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTanggalImunisasi() {
        return tanggalImunisasi;
    }

    public void setTanggalImunisasi(Date tanggalImunisasi) {
        this.tanggalImunisasi = tanggalImunisasi;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    

 
    
    
}