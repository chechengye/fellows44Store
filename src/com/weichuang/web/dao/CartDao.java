package com.weichuang.web.dao;

import com.weichuang.web.pojo.Cart;
import com.weichuang.web.pojo.CartAndProduct;
import com.weichuang.web.util.C3p0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class CartDao {
    private  static QueryRunner qr;
    static {
        qr = new QueryRunner(C3p0Util.getDataSource());
    }

    public Cart findCartByUidAndPid(String pid, String uid) {
        try {
            Cart cart = qr.query("select * from t_cart where pid = ? and uid = ?",new BeanHandler<>(Cart.class),pid , uid);
            return cart;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int updateCart(Cart oldCart) {

        try {
            int rows = qr.update("update t_cart set count = ? where id = ?" , oldCart.getCount() , oldCart.getId());
            return rows;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int insertCart(Cart cart) {
        try {
            int rows = qr.update("insert into t_cart values(?,?,?,?)",null , cart.getUid(),cart.getPid() , cart.getCount());
            return rows;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<CartAndProduct> getCartListByUid(String uid) {
        try {
            List<CartAndProduct> cartList = qr.query("select c.id , c.count , p.shop_price as shopPrice , p.pimage , p.pname from t_cart c, " +
                    "product p where c.pid = p.pid and p.is_delete != 1 and c.uid = ?" , new BeanListHandler<>(CartAndProduct.class),uid);
            return cartList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
