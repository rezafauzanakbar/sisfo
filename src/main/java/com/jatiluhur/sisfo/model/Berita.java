package com.jatiluhur.sisfo.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Berita")
public class Berita {
    @Id
    private Long id;

}
