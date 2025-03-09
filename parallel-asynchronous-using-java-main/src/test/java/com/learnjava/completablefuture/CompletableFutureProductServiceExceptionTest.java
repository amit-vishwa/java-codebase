package com.learnjava.completablefuture;

import com.learnjava.domain.Product;
import com.learnjava.service.InventoryService;
import com.learnjava.service.ProductInfoService;
import com.learnjava.service.ProductService;
import com.learnjava.service.ReviewService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CompletableFutureProductServiceExceptionTest {

    @Mock
    ReviewService reviewService;
    @Mock
    ProductInfoService productInfoService;
    @Mock
    InventoryService inventoryService;

    @InjectMocks
    CompletableFutureProductService completableFutureProductService;

    @Test
    void retrieveProductDetails_ReviewException() {
        // given
        String productId = "ABC123";
        when(reviewService.retrieveReviews(any())).thenThrow(new RuntimeException("Exception in review"));
        when(productInfoService.retrieveProductInfo(any())).thenCallRealMethod();
        when(inventoryService.addInventory(any())).thenCallRealMethod();
        // when
        Product product = completableFutureProductService.retrieveProductDetailsWithInventory(productId);
        // then
        assertNotNull(product);
        assertNotNull(product.getReview());
        assertNotNull(product.getProductInfo());
        assertFalse(product.getProductInfo().getProductOptions().isEmpty());
        product.getProductInfo().getProductOptions().forEach(productOption -> {
            assertNotNull(productOption.getInventory());
        });
        assertEquals(0, product.getReview().getNoOfReviews());
    }

    @Test
    void retrieveProductDetails_ProductInfoException() {
        // given
        String productId = "ABC123";
        when(reviewService.retrieveReviews(any())).thenCallRealMethod();
        // below gives unnecessary stubbings error as inventory is dependent on productInfo
//        when(inventoryService.addInventory(any())).thenCallRealMethod();
        when(productInfoService.retrieveProductInfo(any())).thenThrow(new RuntimeException("Exception in review"));
        // when
        // then
        Assertions.assertThrows(RuntimeException.class,()->completableFutureProductService
                .retrieveProductDetailsWithInventory(productId));
    }

    @Test
    void retrieveProductDetails_InventoryException() {
        // given
        String productId = "ABC123";
        when(reviewService.retrieveReviews(any())).thenCallRealMethod();
        when(productInfoService.retrieveProductInfo(any())).thenCallRealMethod();
        when(inventoryService.addInventory(any())).thenThrow(new RuntimeException("Exception in review"));
        // when
        Product product = completableFutureProductService.retrieveProductDetailsWithInventory(productId);
        // then
        assertNotNull(product);
        assertNotNull(product.getReview());
        assertNotNull(product.getProductInfo());
        assertFalse(product.getProductInfo().getProductOptions().isEmpty());
        product.getProductInfo().getProductOptions().forEach(productOption -> {
            assertNotNull(productOption.getInventory());
            assertEquals(1, productOption.getInventory().getCount());
        });
    }

}