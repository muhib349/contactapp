package com.contactapp.dao;

import com.contactapp.domain.Contact;
import com.contactapp.domain.User;

import java.util.List;

/**
 * Created by gazi_muhib on 8/17/17.
 */
public interface ContactDao {

    public void save(Contact c);
    public void update(Contact c);
    public void delete(Contact c);
    public void delete(Integer contactId);
    public Contact findById(Integer contactId);
    public List<Contact> findAll();
    public List<Contact> findByColumn(String columnName,Object value);
}
