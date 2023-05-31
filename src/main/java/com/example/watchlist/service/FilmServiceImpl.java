package com.example.watchlist.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.watchlist.entity.Film;
import com.example.watchlist.repository.FilmRepository;

@Service
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;

    public FilmServiceImpl(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    public Film saveFilm(Film film) {
        return filmRepository.save(film);
    }

    @Override
    public List<Film> fetchAllFilms() {
        return filmRepository.findAll();
    }

    @Override
    public Film getFilmById(Long id) {
        return filmRepository.findById(id).orElse(null);
    }

    @Override
    public Film updateFilmById(Long id, Film film) {
        Film existingFilm = filmRepository.findById(id).orElse(null);
        if (existingFilm != null) {
            existingFilm.setFilmName(film.getFilmName());
            existingFilm.setFilmYear(film.getFilmYear());
            existingFilm.setFilmDirector(film.getFilmDirector());
            return filmRepository.save(existingFilm);
        }
        return null;
    }

    @Override
    public void deleteAllFilms() {
        filmRepository.deleteAll();
    }

    @Override
    public void deleteFilmById(Long id) {
        filmRepository.deleteById(id);
    }

}
