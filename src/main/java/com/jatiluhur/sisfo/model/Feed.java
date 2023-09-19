package com.jatiluhur.sisfo.model;

import javax.persistence.*;

@Entity
@Table(name = "Feed")
public class Feed {
    private static final Long serializeVersion = 70002L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long idFeed;
    @Column(name = "Comment")
    private String comment;
    @Column(name = "Nik")
    private String nik;
    @Column(name = "IsComplain")
    private boolean isComplain;

    public Long getIdFeed() {
        return idFeed;
    }

    public void setIdFeed(Long idFeed) {
        this.idFeed = idFeed;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public boolean isComplain() {
        return isComplain;
    }

    public void setComplain(boolean complain) {
        isComplain = complain;
    }
}