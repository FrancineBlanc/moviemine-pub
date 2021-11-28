package com.movieminers.moviemine.film;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;

public class FilmSummary {
    private Long id;

    private String title;

    @JsonProperty(value="release_date")
    private String releaseDate;

    //TODO - deal with genres which are returned as genreids
    private String genre;
    
    @JsonProperty(value="poster_path")
    private String posterPath;

    private String overview;

    public FilmSummary() {
    }

    public FilmSummary(Long id, String title, String releaseDate, String genre, String posterPath,
                       String overview) {
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.posterPath = posterPath;
        this.overview = overview;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPosterPath() throws IOException {
        if(this.posterPath==null){
            return "https://upload.wikimedia.org/wikipedia/commons/a/ac/No_image_available.svg";
        }
        return "https://www.themoviedb.org/t/p/w300" + posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getOverview() {
        if(this.overview.isEmpty()) {
            return "No overview available.";
        }
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}

