package com.learnjava.service;

import com.learnjava.domain.checkout.Cart;
import com.learnjava.domain.checkout.CartItem;
import com.learnjava.domain.checkout.CheckoutResponse;
import com.learnjava.domain.checkout.CheckoutStatus;
import com.learnjava.util.CommonUtil;

import java.util.List;

import static com.learnjava.util.LoggerUtil.log;
import static java.util.stream.Collectors.summingDouble;

public class CheckoutService {

    private PriceValidatorService priceValidatorService;

    public CheckoutService(PriceValidatorService priceValidatorService){
        this.priceValidatorService = priceValidatorService;
    }

    public CheckoutResponse checkout(Cart cart){
        CommonUtil.stopWatchReset();
        CommonUtil.startTimer();
        List<CartItem> priceValidationList = cart.getCartItemList()
                .stream()
                .parallel()
                .map(cartItem -> {
                    cartItem.setExpired(priceValidatorService.isCartItemInvalid(cartItem));
                    return cartItem;
                }).filter(CartItem::isExpired).toList();
        CommonUtil.timeTaken();
//        return priceValidationList.size() > 0 ? new CheckoutResponse(CheckoutStatus.FAILURE, priceValidationList)
//                : new CheckoutResponse(CheckoutStatus.SUCCESS);
        if(!priceValidationList.isEmpty()){
            return new CheckoutResponse(CheckoutStatus.FAILURE, priceValidationList);
        }
        double finalPrice = calculateFinalPrice(cart.getCartItemList());
        log("Checkout complete and final price is " + finalPrice);
        return new CheckoutResponse(CheckoutStatus.SUCCESS, finalPrice);
    }

    private double calculateFinalPrice(List<CartItem> cartItemList) {
        return cartItemList.stream().map(cartItem -> cartItem.getQuantity() * cartItem.getRate())
                .collect(summingDouble(Double::doubleValue));
//        return cartItemList.stream()
//                .map(cartItem -> (double) cartItem.getQuantity() * cartItem.getRate())
//                .mapToDouble(Double::doubleValue).sum();
//        return cartItemList.stream().map(cartItem -> cartItem.getQuantity() * cartItem.getRate())
//                .reduce(0.0, Double::sum);
    }

}
