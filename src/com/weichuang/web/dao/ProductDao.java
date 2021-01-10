package com.weichuang.web.dao;

import com.weichuang.web.pojo.Product;
import com.weichuang.web.util.C3p0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class ProductDao {

    private  static QueryRunner qr;
    static {
        qr = new QueryRunner(C3p0Util.getDataSource());
    }

    /**
     * 访问数据库获取商品列表
     * @return
     */
    public List<Product> getProductList() {

        try {
            String sql = "select " +
                    "p.pname , " +
                    "p.pid , " +
                    "p.market_price as marketPrice , " +
                    "p.shop_price as shopPrice , " +
                    "p.is_hot as isHot," +
                    "p.pimage from product p";
            List<Product> productList = qr.query(sql, new BeanListHandler<>(Product.class));
            return productList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public Product getProductByPid(String pid) {

        try {
            String sql = "select " +
                    "p.pname , " +
                    "p.pid , " +
                    "p.market_price as marketPrice , " +
                    "p.shop_price as shopPrice , " +
                    "p.is_hot as isHot," +
                    "p.pimage, " +
                    "p.pdesc from product p where pid = ?";
            Product product = qr.query(sql,new BeanHandler<>(Product.class) , pid);
            return product;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取商品的总条数
     * @return
     */
    public int getProductTotalCount() {
        try {
            String sql = "select count(*) from product";
            Long l = (Long)qr.query(sql , new ScalarHandler());
            return l.intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 分页获取商品数据
     * @param currentIndex
     * @param maxCount
     * @return
     */
    public List<Product> getProductListByIndexAndMaxCount(int currentIndex, int maxCount) {
        try {
            String sql = "select " +
                    "p.pname , " +
                    "p.pid , " +
                    "p.market_price as marketPrice , " +
                    "p.shop_price as shopPrice , " +
                    "p.is_hot as isHot," +
                    "p.pimage from product p where p.is_delete != 1 limit ? , ?";
            List<Product> productList = qr.query(sql , new BeanListHandler<>(Product.class) , currentIndex , maxCount);
            return productList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
