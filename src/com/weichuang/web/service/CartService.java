package com.weichuang.web.service;

import com.weichuang.web.pojo.Cart;
import com.weichuang.web.pojo.CartAndProduct;

import java.util.List;

public interface CartService {
    /**
     * 根据pid与uid查询数据库中是否存在记录
     * @param pid
     * @param uid
     * @return
     */
    Cart findCartByUidAndPid(String pid, String uid);

    int updateCart(Cart oldCart);

    int insertCart(Cart cart);

    /**
     * 根据用户获取购物车列表
     * @param uid
     * @return
     */
    List<CartAndProduct> getCartListByUid(String uid);
}
