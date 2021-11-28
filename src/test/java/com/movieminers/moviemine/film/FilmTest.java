package com.movieminers.moviemine.film;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class FilmTest {
    @Test
    void testConstructs() {
        Film subject = new Film(674L, "http://www.example.com/image.jpg","Test Film", "Test Description", "Test " +
                "Review", 5, 1L);
        assertEquals(674L, subject.getMovieId());
        assertEquals("http://www.example.com/image.jpg", subject.getPosterImage());
        assertEquals("Test Film", subject.getName());
        assertEquals("Test Description", subject.getDescription());
        assertEquals("Test Review", subject.getReview());
        assertEquals(5, subject.getRating());
    }
}
