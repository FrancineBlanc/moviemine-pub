package com.movieminers.moviemine.watchlist;

import com.movieminers.moviemine.user.User;

import javax.persistence.*;

@Entity
public class WatchlistFilm {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long movieId;
    private String name;
    @Column(columnDefinition="TEXT")
    private String description;
    private String posterImage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userId", nullable = false, insertable = false, updatable = false)
    private User user;

    private Long userId;

    public WatchlistFilm(Long movieId, String posterImage, String name, String description,
                Long userId) {
        this.movieId = movieId;
        this.posterImage = posterImage;
        this.name = name;
        this.description = description;
        this.userId = userId;
    }

    public WatchlistFilm() {
    }

    public Long getId() {
        return id;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getPosterImage() {
        return posterImage;
    }

    public void setPosterImage(String posterImage) {
        this.posterImage = posterImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
