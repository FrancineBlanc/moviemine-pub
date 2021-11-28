package com.movieminers.moviemine.watchlist;

import com.movieminers.moviemine.film.FilmSummary;
import com.movieminers.moviemine.user.User;
import com.movieminers.moviemine.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.security.Principal;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
public class WatchlistFilmController {
    @Autowired
    private WatchlistFilmRepository watchlistFilmRepository;

    @Autowired
    private UserRepository userRepository;

    @Value("${api_key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/watchlist/film/{id}")
    public RedirectView create(@PathVariable Long id, Principal principal) throws IOException {
        User user = userRepository.findByUsername(principal.getName());
        FilmSummary filmSummary = restTemplate.getForObject("https://api.themoviedb.org/3/movie/" + id + "?api_key=" + apiKey + "&language=en-US",
                FilmSummary.class);
        WatchlistFilm watchlistFilm = new WatchlistFilm(filmSummary.getId(), filmSummary.getPosterPath(),
                filmSummary.getTitle(), filmSummary.getOverview(), user.getId());
        watchlistFilmRepository.save(watchlistFilm);
        return new RedirectView("/watchlist");
    }

    @GetMapping("/watchlist")
    public ModelAndView watchlistPage(Principal principal) {
        User user = userRepository.findByUsername(principal.getName());
        Iterable<WatchlistFilm> watchlist = watchlistFilmRepository.findAllByUserId(user.getId());
        ModelAndView model = new ModelAndView();
        model.addObject("watchlist", watchlist);
        model.setViewName("watchlist");
        return model;
    }

    @PostMapping("/watchlist/{id}/delete")
    public RedirectView delete(@PathVariable Long id, Principal principal) {
        WatchlistFilm watchlistFilm =
                watchlistFilmRepository.findById(id)
                        .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "No film exists with id " + id));
        watchlistFilmRepository.delete(watchlistFilm);
        return new RedirectView("/watchlist");
    }
}
