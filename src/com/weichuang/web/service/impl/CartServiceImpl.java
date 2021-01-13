package com.weichuang.web.service.impl;

import com.weichuang.web.dao.CartDao;
import com.weichuang.web.pojo.Cart;
import com.weichuang.web.pojo.CartAndProduct;
import com.weichuang.web.service.CartService;

import java.util.List;

public class CartServiceImpl implements CartService {

    CartDao cartDao;
    public CartServiceImpl(){
        cartDao = new CartDao();
    }
    @Override
    public Cart findCartByUidAndPid(String pid, String uid) {
        return cartDao.findCartByUidAndPid(pid,uid);
    }

    @Override
    public int updateCart(Cart oldCart) {
        return cartDao.updateCart(oldCart);
    }

    @Override
    public int insertCart(Cart cart) {
        return cartDao.insertCart(cart);
    }

    @Override
    public List<CartAndProduct> getCartListByUid(String uid) {
        return cartDao.getCartListByUid(uid);
    }
}
