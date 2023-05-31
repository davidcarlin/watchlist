package com.example.watchlist.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.watchlist.entity.Film;
import com.example.watchlist.service.FilmService;

@RestController
@RequestMapping("/films")
public class FilmController {

    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @PostMapping
    public ResponseEntity<Film> addFilm(@RequestBody Film film) {
        Film savedFilm = filmService.saveFilm(film);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFilm);
    }

    @GetMapping
    public ResponseEntity<List<Film>> getAllFilms() {
        List<Film> films = filmService.fetchAllFilms();
        return ResponseEntity.ok(films);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Film> getFilmById(@PathVariable Long id) {
        Film film = filmService.getFilmById(id);
        if (film != null) {
            return ResponseEntity.ok(film);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Film> updateFilmById(@PathVariable Long id, @RequestBody Film film) {
        Film updatedFilm = filmService.updateFilmById(id, film);
        if (updatedFilm != null) {
            return ResponseEntity.ok(updatedFilm);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllFilms() {
        filmService.deleteAllFilms();
        return ResponseEntity.ok("All films have been deleted.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFilmById(@PathVariable Long id) {
        Film film = filmService.getFilmById(id);
        if (film != null) {
            filmService.deleteFilmById(id);
            return ResponseEntity.ok("Film with ID " + id + " has been deleted.");
        }
        return ResponseEntity.notFound().build();
    }
}
