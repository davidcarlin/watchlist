package com.example.watchlist.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long filmId;

    private String filmName;

    private Integer filmYear;

    private String filmDirector;

    public Film() {
    }

    public Film(Long filmId, String filmName, Integer filmYear, String filmDirector) {
        this.filmId = filmId;
        this.filmName = filmName;
        this.filmYear = filmYear;
        this.filmDirector = filmDirector;
    }
}
