package com.movieminers.moviemine.film;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FilmSummaryTest {
    @Test
    void testConstructs() throws IOException {
        FilmSummary subject = new FilmSummary(674L, "Test Title", "2021-11-22", "Test Genre",
                "/image.jpg", "Test Overview");
        assertEquals(674L, subject.getId());
        assertEquals("Test Title", subject.getTitle());
        assertEquals("2021-11-22", subject.getReleaseDate());
        assertEquals("Test Genre", subject.getGenre());
        assertEquals("https://www.themoviedb.org/t/p/w300/image.jpg", subject.getPosterPath());
        assertEquals("Test Overview", subject.getOverview());
    }

    @Test
    void testEmptyStringOverview() {
        FilmSummary subject = new FilmSummary();
        subject.setOverview("");
        assertEquals("No overview available.", subject.getOverview());
    }

    @Test
    void testNullPosterPath() throws IOException {
        FilmSummary subject = new FilmSummary();
        subject.setPosterPath(null);
        assertEquals("https://upload.wikimedia.org/wikipedia/commons/a/ac/No_image_available.svg",
                subject.getPosterPath());
    }
}
