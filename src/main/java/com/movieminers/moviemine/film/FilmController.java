package com.movieminers.moviemine.film;

import com.movieminers.moviemine.user.User;
import com.movieminers.moviemine.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.security.Principal;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
public class FilmController {

   @Value("${api_key}")
   private String apiKey;

   @Autowired
   private RestTemplate restTemplate;

   @Autowired
   private FilmRepository filmRepository;

   @Autowired
   private UserRepository userRepository;

   private FilmSummary filmSummary;

   private final ModelAndView dashboardMav = new ModelAndView();

   @GetMapping("/movie/search")
   public ModelAndView getFilmsInfo(@RequestParam String title, Model model) {

      FilmSummaryResponse filmSummaryResponse =
              restTemplate.getForObject("https://api.themoviedb.org/3/search/movie?api_key=" + apiKey + "&query=" + title + "&language=en-US&page=1&include_adult=false",
                      FilmSummaryResponse.class);

      ModelAndView mav = new ModelAndView();
      mav.addObject("results", filmSummaryResponse.getResults());
      mav.setViewName("results");
      return mav;
   }

   @GetMapping("/review/new/{id}")
   public ModelAndView getFilm(@PathVariable Long id) {
      filmSummary =
              restTemplate.getForObject("https://api.themoviedb.org/3/movie/" + id + "?api_key=" + apiKey + "&language=en-US",
                      FilmSummary.class);
      Film film = new Film();

      ModelAndView mav = new ModelAndView();
      mav.addObject("filmSummary", filmSummary);
      mav.addObject("film", film);
      mav.setViewName("add-review");
      return mav;
   }

   @PostMapping(value="/dashboard", consumes="application/x-www-form-urlencoded")
   public RedirectView create(@ModelAttribute Film film, Principal principal) throws IOException {
      FilmSummary chosenFilm = filmSummary;
      User user = userRepository.findByUsername(principal.getName());
      Film addedFilm = new Film(chosenFilm.getId(), chosenFilm.getPosterPath(), chosenFilm.getTitle(), chosenFilm.getOverview(),
              film.getReview(), film.getRating(), user.getId());
      filmRepository.save(addedFilm);

      dashboardMav.addObject("film", addedFilm);
      return new RedirectView("/dashboard");
   }

   @GetMapping("/dashboard")
   public ModelAndView dashboardPage(Model model, Principal principal) {
      User user = userRepository.findByUsername(principal.getName());
      Iterable<Film> reviews = filmRepository.findAllByUserId(user.getId());
      dashboardMav.addObject("reviews", reviews);
      dashboardMav.setViewName("dashboard");
      return dashboardMav;
   }

   @GetMapping("/recommendations/{id}")
   public ModelAndView getRecommendations(@PathVariable Long id) {
      FilmSummaryResponse filmRecommendations = restTemplate.getForObject("https://api.themoviedb.org/3/movie/" + id +
                      "/recommendations?api_key=" + apiKey + "&language=en-US",
              FilmSummaryResponse.class);
      Film selectedFilm = filmRepository.findByMovieId(id);

      ModelAndView mav = new ModelAndView();
      mav.addObject("recommendations", filmRecommendations.getResults());
      mav.addObject("selectedFilmName", selectedFilm.getName());
      mav.setViewName("recommendations");
      return mav;
   }

   @PostMapping("/reviews/{id}/delete")
   public RedirectView delete(@PathVariable Long id, Principal principal) {
      Film film = filmRepository
              .findById(id)
              .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "No review exists with id " + id));
      filmRepository.delete(film);
      return new RedirectView("/dashboard");
   }

   @GetMapping("/review/{movieId}")
   public ModelAndView getReviewDetails(@PathVariable Long movieId) {
      Iterable<Film> reviewDetails = filmRepository.findAllByMovieId(movieId);
      Film film = reviewDetails.iterator().next();

      ModelAndView mav = new ModelAndView();
      mav.addObject("reviewDetails", reviewDetails);
      mav.addObject("film", film);
      mav.setViewName("review-details");
      return mav;
   }
}
