package com.contactapp.services;

import com.contactapp.domain.User;

import java.util.List;

/**
 * Created by gazi_muhib on 8/18/17.
 */
public interface UserService {

    public static final Integer ACTIVE=1;
    public static final Integer BLOCKED=2;
    public static final Integer ROLE_ADMIN=1;
    public static final Integer ROLE_USER=2;


    public void register(User u);
    public User login(String username,String password);
    public List<User> getAllUserList();
    public void changeLoginStatus(Integer userId, Integer status);
}
