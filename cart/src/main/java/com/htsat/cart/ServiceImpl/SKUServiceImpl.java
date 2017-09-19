package com.htsat.cart.ServiceImpl;

import com.htsat.cart.dao.REcSkuMapper;
import com.htsat.cart.model.REcSku;
import com.htsat.cart.service.ISKUService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SKUServiceImpl implements ISKUService{

    @Autowired
    REcSkuMapper skuMapper;

    @Override
    public boolean updateSKUQuantity(int skuId, int quantity) throws Exception{
        REcSku sku = skuMapper.selectByPrimaryKey(skuId);
        if (sku.getNinventory() < quantity) {
            return false;
        }
        sku.setNinventory(sku.getNinventory() - quantity);
        int result = skuMapper.updateByPrimaryKeySelective(sku);
        if (result != 1) {
            throw new Exception();
        }
        return true;
    }
}
