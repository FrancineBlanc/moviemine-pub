package com.movieminers.moviemine.film;

import java.util.List;

public class FilmSummaryResponse {
    private List<FilmSummary> results;

    public FilmSummaryResponse() {
    }

    public FilmSummaryResponse(List<FilmSummary> results) {
        this.results = results;
    }

    public List<FilmSummary> getResults() {
        return results;
    }

    public void setResults(List<FilmSummary> results) {
        this.results = results;
    }
}
