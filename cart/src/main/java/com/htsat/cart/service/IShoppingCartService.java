package com.htsat.cart.service;

import com.htsat.cart.model.REcShoppingcart;

public interface IShoppingCartService {

    boolean createShoppingCart(int userId, String currency) throws Exception;

    boolean deleteShoppingCart(int userId) throws Exception;

    REcShoppingcart getShoppingCart(int userId) throws Exception;

    REcShoppingcart updateShoppingCart(int userId) throws Exception;
}
