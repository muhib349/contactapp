package com.contactapp.dao;

import com.contactapp.domain.User;
import com.contactapp.rowmapper.UserRowMapper;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gazi_muhib on 8/17/17.
 */

@Repository
public class UserDaoImpl extends BaseDao implements UserDao{

    public void save(User u) {
        String sql="INSERT INTO user(name,phone,email,address,loginName,password,role,loginStatus) " +
                "VALUES(:name,:phone,:email,:address,:loginName,:password,:role,:loginStatus)";

        Map map=new HashMap();

        map.put("name",u.getName());
        map.put("phone",u.getPhone());
        map.put("email",u.getEmail());
        map.put("address",u.getAddress());
        map.put("loginName",u.getLogin_name());
        map.put("password",u.getPassword());
        map.put("role",u.getRole());
        map.put("loginStatus",u.getLogin_status());

        KeyHolder key=new GeneratedKeyHolder();
        SqlParameterSource ps=new MapSqlParameterSource(map);
        getNamedParameterJdbcTemplate().update(sql,ps,key);

        Integer userId=key.getKey().intValue();
        u.setUser_id(userId);
    }

    public void update(User u) {
        String sql="UPDATE user SET " +
                "name=:name," +
                "phone=:phone," +
                "email=:email," +
                "address=:address," +
                "role=:role," +
                "loginStatus=:loginStatus" +
                " WHERE userID=:userId";

        Map map=new HashMap();

        map.put("name",u.getName());
        map.put("phone",u.getPhone());
        map.put("email",u.getEmail());
        map.put("address",u.getAddress());
        map.put("role",u.getRole());
        map.put("loginStatus",u.getLogin_status());
        map.put("userId",u.getUser_id());

        getNamedParameterJdbcTemplate().update(sql,map);

    }

    public void delete(User u) {
        this.delete(u.getUser_id());
    }

    public void delete(Integer userId) {
        String sql="DELETE FROM user WHERE userId=?";

        getJdbcTemplate().update(sql,userId);
    }

    public User findById(Integer userId) {

        String sql="SELECT userId,name,phone,email,address,loginName,role,loginStatus" +
                " FROM user WHERE userId=?";

        return getJdbcTemplate().queryForObject(sql,new UserRowMapper(),userId);

    }

    public List<User> findAll() {
        String sql="SELECT userId,name,phone,email,address,loginName,role,loginStatus" +
                " FROM user";

        return getJdbcTemplate().query(sql,new UserRowMapper());

    }

    public List<User> findByColumn(String columnName, Object value) {


        String sql="SELECT userId,name,phone,email,address,loginName,role,loginStatus" +
                " FROM user WHERE "+columnName+"=?";

        return getJdbcTemplate().query(sql,new UserRowMapper(),value);
    }
}
