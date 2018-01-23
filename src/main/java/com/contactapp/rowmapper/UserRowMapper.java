package com.contactapp.rowmapper;

import com.contactapp.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by gazi_muhib on 8/17/17.
 */
public class UserRowMapper implements RowMapper<User> {

    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user=new User();

        user.setUser_id(resultSet.getInt("userId"));
        user.setName(resultSet.getString("name"));
        user.setPhone(resultSet.getString("phone"));
        user.setEmail(resultSet.getString("email"));
        user.setAddress(resultSet.getString("address"));
        user.setLogin_name(resultSet.getString("loginName" ));
        user.setRole(resultSet.getInt("role"));
        user.setLogin_status(resultSet.getInt("loginStatus"));


        return user;
    }
}
