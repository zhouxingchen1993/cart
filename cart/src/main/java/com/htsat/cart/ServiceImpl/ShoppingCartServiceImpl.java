package com.htsat.cart.ServiceImpl;

import com.htsat.cart.dao.REcShoppingcartMapper;
import com.htsat.cart.model.REcShoppingcart;
import com.htsat.cart.service.IShoppingCartService;
import com.htsat.cart.utils.ComputeUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.Date;

@Service
public class ShoppingCartServiceImpl implements IShoppingCartService {

//    private Logger logger = Logger.getLogger(ShoppingCartServiceImpl.class);

    @Autowired
    private REcShoppingcartMapper shoppingcartMapper;

    @Override
    public boolean createShoppingCart(int userId, String currency) throws Exception {

        //校验用户ID

        int quantity = ComputeUtils.computeNumber();
        float discount = ComputeUtils.computeDiscount();
        BigDecimal totalPrice = ComputeUtils.computeTotalPrice();

        REcShoppingcart shoppingcart = new REcShoppingcart();
        shoppingcart.setNuserid(userId);
        shoppingcart.setScurrency(currency);
        shoppingcart.setSupdatetime(new Date());
        shoppingcart.setNtotalquantity(quantity);
        shoppingcart.setNdiscount(discount);
        shoppingcart.setNtotalprice(totalPrice);

        int insertResult = shoppingcartMapper.insert(shoppingcart);
        if (insertResult != 1){
            throw new Exception();
        }

        return true;
    }

    @Override
    public boolean deleteShoppingCart(int userId) throws Exception{
        int deleteResult = shoppingcartMapper.deleteByPrimaryKey(userId);
        if (deleteResult != 1) {
            throw new Exception();
        }
        return true;
    }

    @Override
    public REcShoppingcart getShoppingCart(int userId) throws Exception{
        REcShoppingcart shoppingcart = shoppingcartMapper.selectByPrimaryKey(userId);
        if (shoppingcart == null) {
            throw new Exception();
        }
        return shoppingcart;
    }

    @Override
    public REcShoppingcart updateShoppingCart(int userId) throws Exception{
        int quantity = ComputeUtils.computeNumber();
        float discount = ComputeUtils.computeDiscount();
        BigDecimal totalPrice = ComputeUtils.computeTotalPrice();

        REcShoppingcart shoppingcart = new REcShoppingcart();
        shoppingcart.setNuserid(userId);
        shoppingcart.setNtotalquantity(quantity);
        shoppingcart.setNdiscount(discount);
        shoppingcart.setNtotalprice(totalPrice);

        int updateResult = shoppingcartMapper.updateByPrimaryKeySelective(shoppingcart);
        if (updateResult != 1) {
            throw new Exception();
        }

        REcShoppingcart shoppingcartResult = shoppingcartMapper.selectByPrimaryKey(userId);
        if (shoppingcartResult == null) {
            throw new Exception();
        }
        return shoppingcartResult;
    }


}
