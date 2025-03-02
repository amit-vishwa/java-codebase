package com.learnjava.thread;

import com.learnjava.domain.Product;
import com.learnjava.domain.ProductInfo;
import com.learnjava.domain.Review;
import com.learnjava.service.ProductInfoService;
import com.learnjava.service.ReviewService;
import lombok.Getter;

import static com.learnjava.util.CommonUtil.stopWatch;
import static com.learnjava.util.LoggerUtil.log;

/**
 * Thread was introduced in Java1.
 * It is not so developer friendly hence enhancement were done in later versions.
 * */
public class ProductServiceUsingThread {
    private ProductInfoService productInfoService;
    private ReviewService reviewService;

    public ProductServiceUsingThread(ProductInfoService productInfoService, ReviewService reviewService) {
        this.productInfoService = productInfoService;
        this.reviewService = reviewService;
    }

    public Product retrieveProductDetails(String productId) throws InterruptedException {
        stopWatch.start();

        ProductInfoRunnable productInfoRunnable = new ProductInfoRunnable(productId);
        ReviewRunnable reviewRunnable = new ReviewRunnable(productId);

        Thread productInfoThread = new Thread(productInfoRunnable);
        Thread reviewThread = new Thread(reviewRunnable);
        productInfoThread.start();
        reviewThread.start();
        productInfoThread.join();
        reviewThread.join();

//        ProductInfo productInfo = productInfoService.retrieveProductInfo(productId); // blocking call
//        Review review = reviewService.retrieveReviews(productId); // blocking call
        ProductInfo productInfo = productInfoRunnable.getProductInfo(); // non-blocking call
        Review review = reviewRunnable.getReview(); // non-blocking asynchronous call

        stopWatch.stop();
        log("Total Time Taken : "+ stopWatch.getTime());
        return new Product(productId, productInfo, review);
    }

    public static void main(String[] args) throws InterruptedException {

        ProductInfoService productInfoService = new ProductInfoService();
        ReviewService reviewService = new ReviewService();
        ProductServiceUsingThread productService = new ProductServiceUsingThread(productInfoService, reviewService);
        String productId = "ABC123";
        Product product = productService.retrieveProductDetails(productId);
        log("Product is " + product);

    }

    class ProductInfoRunnable implements Runnable{
        @Getter
        private ProductInfo productInfo;
        private String productId;
        public ProductInfoRunnable(String productId){
            this.productId = productId;
        }

        @Override
        public void run(){
            productInfo = productInfoService.retrieveProductInfo(productId);
        }
    }

    class ReviewRunnable implements Runnable{
        private Review review;
        private String productId;
        public ReviewRunnable(String productId){
            this.productId = productId;
        }
        public Review getReview(){
            return review;
        }
        @Override
        public void run(){
            review = reviewService.retrieveReviews(productId);
        }
    }

}
