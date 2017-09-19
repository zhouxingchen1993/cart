package com.htsat.cart.ServiceImpl;

import com.htsat.cart.dao.REcCartskuMapper;
import com.htsat.cart.model.REcCartsku;
import com.htsat.cart.model.REcCartskuKey;
import com.htsat.cart.service.ICartSKUService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartSKUServiceImpl implements ICartSKUService {

    @Autowired
    private REcCartskuMapper cartskuMapper;

    @Override
    public boolean createCartSKU(int userId, int skuId, int quantity) throws Exception {

        //check userId, skuId, quantity
        REcCartsku cartsku = new REcCartsku();
        cartsku.setNuserid(userId);
        cartsku.setNproductid(skuId);
        cartsku.setNquantity(quantity);

        int result = cartskuMapper.insert(cartsku);
        if (result != 1) {
            throw new Exception();
        }
        return true;
    }

    @Override
    public boolean deleteCartSKU(int userId, int skuId) throws Exception {
        REcCartskuKey cartskuKey = new REcCartskuKey();
        cartskuKey.setNuserid(userId);
        cartskuKey.setNproductid(skuId);

        int result = cartskuMapper.deleteByPrimaryKey(cartskuKey);
        if (result != 1) {
            throw new Exception();
        }
        return true;
    }

    @Override
    public boolean updateCartSKU(int userId, int skuId, int quantity) throws Exception {
        REcCartsku cartsku = new REcCartsku();
        cartsku.setNuserid(userId);
        cartsku.setNproductid(skuId);
        cartsku.setNquantity(quantity);

        int result = cartskuMapper.updateByPrimaryKeySelective(cartsku);
        if (result != 1) {
            throw new Exception();
        }
        return true;
    }

    @Override
    public REcCartsku getCartSKU(int userId, int skuId) throws Exception {
        REcCartskuKey cartskuKey = new REcCartskuKey();
        cartskuKey.setNuserid(userId);
        cartskuKey.setNproductid(skuId);

        REcCartsku cartsku = cartskuMapper.selectByPrimaryKey(cartskuKey);
        if (cartsku == null) {
            throw new Exception();
        }
        return cartsku;
    }
}