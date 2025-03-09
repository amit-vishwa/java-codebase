package com.learnjava.apiclient;

import com.learnjava.domain.movie.Movie;
import com.learnjava.domain.movie.MovieInfo;
import com.learnjava.domain.movie.Review;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MoviesClient {

    private final WebClient webClient;

    public MoviesClient(WebClient webClient){
        this.webClient = webClient;
    }

    public Movie retrieveMovie(Long movieInfoId){
        // movieInfo
        MovieInfo movieInfo = invokeMovieInfoService(movieInfoId);
        // review
        List<Review> reviewList = invokeReviewService(movieInfoId);
        return new Movie(movieInfo,reviewList);
    }

    public List<Movie> retrieveMovies(List<Long> movieInfoIds){
        return movieInfoIds.stream().map(this::retrieveMovie).toList();
    }

    public CompletableFuture<Movie> retrieveMovie_CF(Long movieInfoId){
        // movieInfo
        CompletableFuture<MovieInfo> movieInfoCF = CompletableFuture.supplyAsync(()-> invokeMovieInfoService(movieInfoId));
        // review
        CompletableFuture<List<Review>> reviewListCF = CompletableFuture.supplyAsync(()-> invokeReviewService(movieInfoId));
        return movieInfoCF
                .thenCombine(reviewListCF,
                        Movie::new); // Constructor ref of (movieInfo,reviewList)-> new Movie(movieInfo,reviewList)
    }

    public List<Movie> retrieveMovies_CF(List<Long> movieInfoIds){
        return movieInfoIds.stream().map(this::retrieveMovie_CF).toList().stream().map(CompletableFuture::join).toList();
    }

    /**
     * allOf() is used for parallel calls to List of CompletableFuture.
     * Then result is combined as a CompletableFuture.
     * */
    public List<Movie> retrieveMovies_CF_allOf(List<Long> movieInfoIds){
        List<CompletableFuture<Movie>> cfs = movieInfoIds
                .stream()
                .map(this::retrieveMovie_CF)
                .toList();
        CompletableFuture<Void> cf = CompletableFuture
                .allOf(cfs.
                        toArray(new CompletableFuture[cfs.size()]));
        return cf
                .thenApply(v -> cfs
                        .stream()
                        .map(CompletableFuture::join)
                        .toList())
                .join();
    }

    private MovieInfo invokeMovieInfoService(Long movieInfoId) {
        var moviesInfoUrlPath = "/v1/movie_infos/{movieInfoId}";
        return webClient
                .get()
                .uri(moviesInfoUrlPath, movieInfoId)
                .retrieve()
                .bodyToMono(MovieInfo.class)
                .block();
    }

    private List<Review> invokeReviewService(Long movieInfoId) {
        var reviewUri = UriComponentsBuilder
                .fromUriString("/v1/reviews")
                .queryParam("movieInfoId", movieInfoId)
                .buildAndExpand()
                .toString();
        return webClient
                .get()
                .uri(reviewUri)
                .retrieve()
                .bodyToFlux(Review.class)
                .collectList()
                .block();
    }

}
