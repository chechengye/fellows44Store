package com.weichuang.admin.dao;

import com.weichuang.admin.pojo.Product;
import com.weichuang.web.util.C3p0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

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
                    "p.pimage from product p where p.is_delete != 1 order by p.pdate desc";
            List<Product> productList = qr.query(sql, new BeanListHandler<>(Product.class));
            return productList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public int deleteProductByPid(String pid) {
        try {
            String sql = "update product set is_delete = 1 where pid = ?";
            int rows = qr.update(sql , pid);
            return rows;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int saveProduct(Product product) {
        String sql = "insert into product values (?,?,?,?,?,now(),?,?,?,?,?)";
        try {
            int rows = qr.update(sql,
                    product.getPid(),
                    product.getPname(),
                    product.getMarketPrice(),
                    product.getShopPrice(),
                    product.getPimage(),
                    product.getIsHot(),
                    product.getPdesc(),
                    product.getPflag(),
                    product.getCid(),
                    product.getIsDelete());
            return rows;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
