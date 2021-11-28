package com.movieminers.moviemine.film;

import org.springframework.data.repository.CrudRepository;

public interface FilmRepository extends CrudRepository<Film, Long> {

  Iterable<Film> findAll();
  Iterable<Film> findAllByUserId(Long id);
  Iterable<Film> findAllByMovieId(Long movieId);
  Film findByMovieId(Long movieId);
}
