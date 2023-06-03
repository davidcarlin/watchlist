package com.example.watchlist.controller;

import java.security.Principal;
import java.util.List;
import java.util.Set;

import com.example.watchlist.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.watchlist.entity.Film;
import com.example.watchlist.service.FilmService;

@RestController
@RequestMapping("/films")
public class FilmController {

    private final FilmService filmService;
    private final UserService userService;

    public FilmController(FilmService filmService, UserService userService) {
        this.filmService = filmService;
        this.userService = userService;
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

    @PostMapping("/{filmId}/watchlist")
    public ResponseEntity<?> addToWatchlist(@PathVariable Long filmId, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        Film film = filmService.getFilmById(filmId);
        if (user != null && film != null) {
            user.getWatchlist().add(film);
            userService.saveUser(user);
            return ResponseEntity.ok("Film added to watchlist");
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/watchlist")
    public ResponseEntity<Set<Film>> getWatchlist(Principal principal) {
        User user = userService.findByUsername(principal.getName());
        if (user != null) {
            return ResponseEntity.ok(user.getWatchlist());
        }
        return ResponseEntity.notFound().build();
    }
}
