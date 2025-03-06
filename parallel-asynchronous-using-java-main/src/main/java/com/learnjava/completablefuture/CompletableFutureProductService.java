package com.learnjava.completablefuture;

import com.learnjava.domain.Product;
import com.learnjava.domain.ProductInfo;
import com.learnjava.domain.Review;
import com.learnjava.service.ProductInfoService;
import com.learnjava.service.ProductService;
import com.learnjava.service.ReviewService;

import java.util.concurrent.CompletableFuture;

import static com.learnjava.util.CommonUtil.stopWatch;
import static com.learnjava.util.LoggerUtil.log;

public class CompletableFutureProductService {
    private ProductInfoService productInfoService;
    private ReviewService reviewService;

    public CompletableFutureProductService(ProductInfoService productInfoService, ReviewService reviewService) {
        this.productInfoService = productInfoService;
        this.reviewService = reviewService;
    }

    public Product retrieveProductDetails(String productId) {
        stopWatch.start();

        CompletableFuture<ProductInfo> completableFutureProductInfo = CompletableFuture
                .supplyAsync(()-> productInfoService.retrieveProductInfo(productId));
        CompletableFuture<Review> completableFutureReview = CompletableFuture
                .supplyAsync(()-> reviewService.retrieveReviews(productId));

        Product product = completableFutureProductInfo
                .thenCombine(completableFutureReview,(productInfo,review)->
                        new Product(productId, productInfo, review))
                .join();
        stopWatch.stop();
        log("Total Time Taken : "+ stopWatch.getTime());
        return product;
    }

    /**
     * CompletableFuture can be returned in response at server side.
     * It is on client to block call at its end using join
     * */
    public CompletableFuture<Product> retrieveProductDetails_completableFuture(String productId) {

        CompletableFuture<ProductInfo> completableFutureProductInfo = CompletableFuture
                .supplyAsync(()-> productInfoService.retrieveProductInfo(productId));
        CompletableFuture<Review> completableFutureReview = CompletableFuture
                .supplyAsync(()-> reviewService.retrieveReviews(productId));

        return completableFutureProductInfo
                .thenCombine(completableFutureReview,(productInfo,review)->
                        new Product(productId, productInfo, review));
    }

    public static void main(String[] args) {

        ProductInfoService productInfoService = new ProductInfoService();
        ReviewService reviewService = new ReviewService();
        ProductService productService = new ProductService(productInfoService, reviewService);
        String productId = "ABC123";
        Product product = productService.retrieveProductDetails(productId);
        log("Product is " + product);

    }
}
