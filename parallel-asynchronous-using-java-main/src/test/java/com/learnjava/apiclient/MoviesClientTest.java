package com.learnjava.apiclient;

import com.learnjava.domain.movie.Movie;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

import static com.learnjava.util.CommonUtil.*;
import static org.junit.jupiter.api.Assertions.*;

class MoviesClientTest {

    WebClient webClient = WebClient.builder().baseUrl("http://localhost:8080/movies").build();
    MoviesClient moviesClient = new MoviesClient(webClient);

    @RepeatedTest(10)
    void retrieveMovie() {
        stopWatchReset();
        startTimer();
        // given
        long movieInfoId = 1;
        // when
        Movie movie = moviesClient.retrieveMovie(movieInfoId);
        System.out.println(movie);
        timeTaken();
        // then
        assert movie != null && movie.getMovieInfo() != null && movie.getReviewList().size() == 1;
        assertEquals("Batman Begins", movie.getMovieInfo().getName());
    }

    @RepeatedTest(10)
    void retrieveMovies() {
        stopWatchReset();
        startTimer();
        // given
        List<Long> movieInfoIds = List.of(1L,2L,3L,4L,5L);
        // when
        List<Movie> movies = moviesClient.retrieveMovies(movieInfoIds);
        System.out.println(movies);
        timeTaken();
        // then
        assert movies != null && movies.size() == 5;
        assertEquals("Batman Begins", movies.get(0).getMovieInfo().getName());
    }

    @RepeatedTest(10)
    void retrieveMovieCF() {
        stopWatchReset();
        startTimer();
        // given
        long movieInfoId = 1;
        // when
        Movie movie = moviesClient.retrieveMovie_CF(movieInfoId).join();
        System.out.println(movie);
        timeTaken();
        // then
        assert movie != null && movie.getMovieInfo() != null && movie.getReviewList().size() == 1;
        assertEquals("Batman Begins", movie.getMovieInfo().getName());
    }

    @RepeatedTest(10)
    void retrieveMoviesCF() {
        stopWatchReset();
        startTimer();
        // given
        List<Long> movieInfoIds = List.of(1L,2L,3L,4L,5L);
        // when
        List<Movie> movies = moviesClient.retrieveMovies_CF(movieInfoIds);
        System.out.println(movies);
        timeTaken();
        // then
        assert movies != null && movies.size() == 5;
        assertEquals("Batman Begins", movies.get(0).getMovieInfo().getName());
    }

    @RepeatedTest(10)
    void retrieveMoviesCFAllOf() {
        stopWatchReset();
        startTimer();
        // given
        List<Long> movieInfoIds = List.of(1L,2L,3L,4L,5L);
        // when
        List<Movie> movies = moviesClient.retrieveMovies_CF_allOf(movieInfoIds);
        System.out.println(movies);
        timeTaken();
        // then
        assert movies != null && movies.size() == 5;
        assertEquals("Batman Begins", movies.get(0).getMovieInfo().getName());
    }

}