package com.example.watchlist.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany(mappedBy = "watchlist")
    private Set<User> users = new HashSet<>();


    public Film() {
    }

    public Film(Long filmId, String filmName, Integer filmYear, String filmDirector) {
        this.filmId = filmId;
        this.filmName = filmName;
        this.filmYear = filmYear;
        this.filmDirector = filmDirector;
    }
}
