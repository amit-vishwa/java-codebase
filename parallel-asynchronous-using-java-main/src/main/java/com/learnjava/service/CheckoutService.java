package com.learnjava.service;

import com.learnjava.domain.checkout.Cart;
import com.learnjava.domain.checkout.CartItem;
import com.learnjava.domain.checkout.CheckoutResponse;
import com.learnjava.domain.checkout.CheckoutStatus;
import com.learnjava.util.CommonUtil;

import java.util.List;

public class CheckoutService {

    private PriceValidatorService priceValidatorService;

    public CheckoutService(PriceValidatorService priceValidatorService){
        this.priceValidatorService = priceValidatorService;
    }

    public CheckoutResponse checkout(Cart cart){
        CommonUtil.startTimer();
        List<CartItem> priceValidationList = cart.getCartItemList()
                .stream()
                .parallel()
                .map(cartItem -> {
                    cartItem.setExpired(priceValidatorService.isCartItemInvalid(cartItem));
                    return cartItem;
                }).filter(CartItem::isExpired).toList();
        CommonUtil.timeTaken();
        return priceValidationList.size() > 0 ? new CheckoutResponse(CheckoutStatus.FAILURE, priceValidationList)
                : new CheckoutResponse(CheckoutStatus.SUCCESS);
    }

}
