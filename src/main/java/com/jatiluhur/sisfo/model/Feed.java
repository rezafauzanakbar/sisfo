package com.jatiluhur.sisfo.model;

import javax.persistence.*;

@Entity
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

    public Long getIdFeed() {
        return idFeed;
    }

    public void setIdFeed(Long idFeed) {
        this.idFeed = idFeed;
    }

    @Column(name = "IsComplain")
    private boolean isComplain;
}