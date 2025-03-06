package com.learnjava.completablefuture;

import com.learnjava.domain.Product;
import com.learnjava.service.ProductInfoService;
import com.learnjava.service.ReviewService;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;

import static com.learnjava.util.CommonUtil.*;
import static org.junit.jupiter.api.Assertions.*;

class CompletableFutureProductServiceTest {

    public CompletableFutureProductService service = new CompletableFutureProductService(new ProductInfoService(),
            new ReviewService());

    @Test
    void retrieveProductDetails() {
        // given
        String productId = "ABC123";
        // when
        Product product = service.retrieveProductDetails(productId);
        // then
        assertNotNull(product);
        assertNotNull(product.getReview());
        assertNotNull(product.getProductInfo());
        assertFalse(product.getProductInfo().getProductOptions().isEmpty());
    }

    @Test
    void retrieveProductDetails_completableFuture() {
        // given
        String productId = "ABC123";
        // when
        CompletableFuture<Product> completableFutureProduct = service.retrieveProductDetails_completableFuture(productId);
        // then
        stopWatchReset();
        startTimer();
        completableFutureProduct.thenAccept(product -> {
            assertNotNull(product);
            assertNotNull(product.getReview());
            assertNotNull(product.getProductInfo());
            assertFalse(product.getProductInfo().getProductOptions().isEmpty());
        }).join();
        timeTaken();
    }

}