package com.htsat.cart.service;

import com.htsat.cart.model.REcCartsku;

public interface ICartSKUService {

    boolean createCartSKU(int userId, int skuId, int quantity) throws Exception;

    boolean deleteCartSKU(int userId, int skuId) throws Exception;

    boolean updateCartSKU(int userId, int skuId, int quantity) throws Exception;

    REcCartsku getCartSKU(int userId, int skuId) throws Exception;
}
