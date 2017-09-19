package com.htsat.cart.web;

import com.htsat.cart.dao.REcShoppingcartMapper;
import com.htsat.cart.model.REcShoppingcart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class ShoppingCartController {

    @Autowired
    REcShoppingcartMapper shoppingcartMapper;

//    @Autowired
//    RestTemplate restTemplate;
//
//    @RequestMapping(value = "/add", method = RequestMethod.GET)
//    public String add() {
//        return restTemplate.getForEntity("http://CART-SERVICE/add?a=10&b=20", String.class).getBody();
//    }

    @RequestMapping(value = "/carts/{user_id}", method = RequestMethod.GET)
    public REcShoppingcart getShoppingCart(@PathVariable("user_id") Integer user_id){
        return shoppingcartMapper.selectByPrimaryKey(user_id);
    }

    @RequestMapping(value = "/carts/{user_id}", method = RequestMethod.DELETE)
    public int deleteShoppingCart(@PathVariable("user_id") Integer user_id){
        return shoppingcartMapper.deleteByPrimaryKey(user_id);
    }

}
