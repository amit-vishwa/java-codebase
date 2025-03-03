package com.learnjava.service;

import com.learnjava.domain.checkout.Cart;
import com.learnjava.domain.checkout.CheckoutResponse;
import com.learnjava.domain.checkout.CheckoutStatus;
import com.learnjava.util.DataSet;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ForkJoinPool;

import static org.junit.jupiter.api.Assertions.*;

class CheckoutServiceTest {

    PriceValidatorService priceValidatorService = new PriceValidatorService();
    CheckoutService checkoutService = new CheckoutService(priceValidatorService);

    @Test
    void checkout_6_items() {
        // given
        Cart cart = DataSet.createCart(6);
        // when
        CheckoutResponse checkoutResponse = checkoutService.checkout(cart);
        // then
        assertEquals(CheckoutStatus.SUCCESS,checkoutResponse.getCheckoutStatus());
        assertTrue(checkoutResponse.getFinalRate() > 0);
    }

    @Test
    void checkout_25_items() {
        // given
        Cart cart = DataSet.createCart(25);
        // when
        CheckoutResponse checkoutResponse = checkoutService.checkout(cart);
        // then
        assertEquals(CheckoutStatus.FAILURE,checkoutResponse.getCheckoutStatus());
    }

    @Test
    void parallelism() {
        // one core is used by thread CheckoutServiceTest, hence output is 7 off 8
        System.out.println("Parallelism: " + ForkJoinPool.getCommonPoolParallelism());
    }

    @Test
    void modify_parallelism() {
        // given
        // we can set worker threads count using below
//        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "100");
        Cart cart = DataSet.createCart(100);
        // when
        CheckoutResponse checkoutResponse = checkoutService.checkout(cart);
        // then
        assertEquals(CheckoutStatus.FAILURE,checkoutResponse.getCheckoutStatus());
    }

}