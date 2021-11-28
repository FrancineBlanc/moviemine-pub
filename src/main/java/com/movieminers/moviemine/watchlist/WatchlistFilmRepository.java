package com.movieminers.moviemine.watchlist;

import org.springframework.data.repository.CrudRepository;

public interface WatchlistFilmRepository extends CrudRepository<WatchlistFilm, Long> {
    Iterable<WatchlistFilm> findAllByUserId(Long id);
}
