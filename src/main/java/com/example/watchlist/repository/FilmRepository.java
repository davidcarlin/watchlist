package com.example.watchlist.repository;

import com.example.watchlist.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    // You can add custom query methods or use the default methods provided by
    // JpaRepository
}
