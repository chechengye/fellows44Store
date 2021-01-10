package com.weichuang.dao;

import com.weichuang.pojo.User;
import com.weichuang.util.C3p0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDao {
    private static QueryRunner qr;
    static {
        qr = new QueryRunner(C3p0Util.getDataSource());
    }

    public int registerUser(User user) {
        try {
            String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?,?)";
            int rows = qr.update(sql , user.getUid(),
                    user.getUsername(),
                    user.getPassword(),
                    user.getName(),
                    user.getHobby(),
                    user.getEmail(),
                    user.getTelephone(),
                    user.getBirthday(),
                    user.getSex(), 0,0);
            return rows;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public User login(String username, String password) {

        try {
            User user = qr.query("select u.name from user u where u.username = ? and u.password = ? and u.is_delete != 1"
                    , new BeanHandler<>(User.class), username, password);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
