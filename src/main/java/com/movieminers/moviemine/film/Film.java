package com.movieminers.moviemine.film;

import com.movieminers.moviemine.user.User;

import javax.persistence.*;

@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long movieId;
    private String name;

    @Column(columnDefinition="TEXT")
    private String description;

    @Column(columnDefinition="TEXT")
    private String review;
    private Integer rating;
    private String posterImage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userId", nullable = false, insertable = false, updatable = false)
    private User user;

    private Long userId;

    public Film(Long movieId, String posterImage, String name, String description, String review, Integer rating,
                Long userId) {
        this.movieId = movieId;
        this.posterImage = posterImage;
        this.name = name;
        this.description = description;
        this.review = review;
        this.rating = rating;
        this.userId = userId;
    }


    public Film() {
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

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public User getUser(){
        return this.user;
    }
}
