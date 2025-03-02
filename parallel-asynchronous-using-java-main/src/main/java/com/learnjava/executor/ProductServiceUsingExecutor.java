package com.learnjava.executor;

import com.learnjava.domain.Product;
import com.learnjava.domain.ProductInfo;
import com.learnjava.domain.Review;
import com.learnjava.service.ProductInfoService;
import com.learnjava.service.ReviewService;

import java.util.concurrent.*;

import static com.learnjava.util.CommonUtil.stopWatch;
import static com.learnjava.util.LoggerUtil.log;

/**
 * ExecutorService was introduced in Java 5.
 * It uses the principle of Task Parallelism.
 * */
public class ProductServiceUsingExecutor {
    ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private ProductInfoService productInfoService;
    private ReviewService reviewService;

    public ProductServiceUsingExecutor(ProductInfoService productInfoService, ReviewService reviewService) {
        this.productInfoService = productInfoService;
        this.reviewService = reviewService;
    }

    public Product retrieveProductDetails(String productId) {
        stopWatch.start();

        Future<ProductInfo> productInfoFuture = executorService.submit(()->productInfoService.retrieveProductInfo(productId));
        Future<Review> reviewFuture = executorService.submit(()->reviewService.retrieveReviews(productId));

//        ProductInfo productInfo = productInfoService.retrieveProductInfo(productId); // blocking call
//        Review review = reviewService.retrieveReviews(productId); // blocking call

        try{
            // below will give timeout exception if timeout is 1s as productInfoService will wait for 1s
            // so it cannot complete task in 1s
            ProductInfo productInfo = productInfoFuture.get(2, TimeUnit.SECONDS); // non-blocking call
            Review review = reviewFuture.get(); // non-blocking call, executed only after product info completion
            // To avoid blocking CompletableFuture is introduced

            stopWatch.stop();
            log("Total Time Taken : "+ stopWatch.getTime());
            executorService.shutdown(); // service need to shutdown manually
            return new Product(productId, productInfo, review);
        }catch (InterruptedException|TimeoutException|ExecutionException e){log("Exception: " + e);}

        stopWatch.stop();
        log("Total Time Taken : "+ stopWatch.getTime());
        executorService.shutdown(); // service need to shutdown manually
        return new Product();
    }

    public static void main(String[] args){

        ProductInfoService productInfoService = new ProductInfoService();
        ReviewService reviewService = new ReviewService();
        ProductServiceUsingExecutor productService = new ProductServiceUsingExecutor(productInfoService, reviewService);
        String productId = "ABC123";
        Product product = productService.retrieveProductDetails(productId);
        log("Product is " + product);
    }
}
