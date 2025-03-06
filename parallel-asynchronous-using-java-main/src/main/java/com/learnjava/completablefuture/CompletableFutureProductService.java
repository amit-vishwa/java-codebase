package com.learnjava.completablefuture;

import com.learnjava.domain.*;
import com.learnjava.service.InventoryService;
import com.learnjava.service.ProductInfoService;
import com.learnjava.service.ProductService;
import com.learnjava.service.ReviewService;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static com.learnjava.util.CommonUtil.stopWatch;
import static com.learnjava.util.CommonUtil.stopWatchReset;
import static com.learnjava.util.LoggerUtil.log;

public class CompletableFutureProductService {
    private ProductInfoService productInfoService;
    private ReviewService reviewService;
    private InventoryService inventoryService;

    public CompletableFutureProductService(ProductInfoService productInfoService, ReviewService reviewService) {
        this.productInfoService = productInfoService;
        this.reviewService = reviewService;
    }

    public CompletableFutureProductService(ProductInfoService productInfoService, ReviewService reviewService, InventoryService inventoryService) {
        this.productInfoService = productInfoService;
        this.reviewService = reviewService;
        this.inventoryService = inventoryService;
    }

    public Product retrieveProductDetails(String productId) {
        stopWatchReset();
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

    public Product retrieveProductDetailsWithInventory(String productId) {
        stopWatchReset();
        stopWatch.start();

        CompletableFuture<ProductInfo> completableFutureProductInfo = CompletableFuture
                .supplyAsync(()-> productInfoService.retrieveProductInfo(productId))
                .thenApply(productInfo -> {
                    productInfo.setProductOptions(updateProductInfo(productInfo)); // blocking call
                    // uncomment below for retrieveProductDetailsWithAsyncInventory testcase
//                    productInfo.setProductOptions(updateProductInfoUsingCompletableFuture(productInfo));
                    return productInfo;
                });
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

    private List<ProductOption> updateProductInfo(ProductInfo productInfo) {
        // below simple approach can be used
//        productInfo.getProductOptions().forEach(product -> product.setInventory(inventoryService.addInventory(product)));
        return  productInfo.getProductOptions().stream()
                .map(product -> {
                    // the service call is blocking and will result in performance issue
                    product.setInventory(inventoryService.addInventory(product));
                    return product;
                })
                .toList();
    }

    private List<ProductOption> updateProductInfoUsingCompletableFuture(ProductInfo productInfo) {

        List<CompletableFuture<ProductOption>> completableFutureList = productInfo.getProductOptions()
                .stream()
                .map(productOption -> {
                    CompletableFuture<Inventory> inventoryCompletableFuture = CompletableFuture
                        .supplyAsync(() -> inventoryService.addInventory(productOption));
                    CompletableFuture<ProductOption> productOptionCompletableFuture = inventoryCompletableFuture
                            .thenApply(inventory -> {
                                productOption.setInventory(inventory);
                                return productOption;
                            });
                    return productOptionCompletableFuture;
                }).toList();

        return completableFutureList
                .stream()
                .map(completableFuture -> {
                    ProductOption productOption = completableFuture.join();
                    return productOption;
                })
                .toList();

        /* // above is more readable code, below is inline code
        return  productInfo
                .getProductOptions()
                .stream()
                .map(product -> {
                    return CompletableFuture
                            // returns CompletableFuture<Inventory>
                            .supplyAsync(() -> inventoryService.addInventory(product))
                            .thenApply(inventory -> {
                                // access inventory and populate as field in product object
                                product.setInventory(inventory);
                                return product; // returns CompletableFuture<ProductOption>
                            }); // now this future must be returned from map
                }).toList()
                .stream()
                // join call performs in parallel and adds only delay of one object call(i.e. 500 in time taken)
                .map(CompletableFuture::join)
                .toList(); // List<ProductOption> is returned
        */
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
