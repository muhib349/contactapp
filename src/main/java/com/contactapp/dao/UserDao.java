package com.contactapp.dao;

import com.contactapp.domain.User;

import java.util.List;

/**
 * Created by gazi_muhib on 8/17/17.
 */
public interface UserDao {

    public void save(User u);
    public void update(User u);
    public void delete(User u);
    public void delete(Integer userId);
    public User findById(Integer userId);
    public List<User> findAll();
    public List<User> findByColumn(String columnName,Object value);
}
