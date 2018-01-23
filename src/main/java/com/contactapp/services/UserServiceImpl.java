package com.contactapp.services;

import com.contactapp.dao.BaseDao;
import com.contactapp.dao.UserDao;
import com.contactapp.domain.User;
import com.contactapp.rowmapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.util.NestedServletException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gazi_muhib on 8/18/17.
 */
@Service
public class UserServiceImpl extends BaseDao implements UserService {

    @Autowired
    private UserDao userDao;

    public void register(User u) {
        userDao.save(u);
    }

    public User login(String username, String password) {

        String sql="SELECT userId,name,phone,email,address,role,loginStatus,loginName" +
                " FROM user WHERE loginName=:name AND password=:pass ";
        Map map=new HashMap();
        map.put("name",username);
        map.put("pass",password);

        User user=null;
        try{
            user=getNamedParameterJdbcTemplate().queryForObject(sql,map,new UserRowMapper());
        }
        catch (EmptyResultDataAccessException ea){
            return null;
        }

        if(user.getLogin_status().equals(UserService.BLOCKED))
        {
            return null;
        }
        else {
            return user;
        }

    }

    public List<User> getAllUserList() {
        return null;
    }

    public void changeLoginStatus(Integer userId, Integer status) {

    }
}
