package com.example.watchlist.service;

import java.util.List;

import com.example.watchlist.entity.Film;

public interface FilmService {
    
    Film saveFilm(Film film);

    List<Film> fetchAllFilms();

    Film getFilmById(Long id);

    Film updateFilmById(Long id, Film film);

    void deleteAllFilms();

    void deleteFilmById(Long id);
}
