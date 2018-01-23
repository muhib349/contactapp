package com.contactapp.services;

import com.contactapp.domain.Contact;
import com.contactapp.domain.User;

import java.util.List;

/**
 * Created by gazi_muhib on 8/18/17.
 */
public interface ContactService {

    public void save(Contact c);
    public void update(Contact c);
    public void delete(Integer contactid);
    public void delete(Integer[] contactIds);
    public List<Contact> findUserContacts(Integer userId);
    public List<Contact> findUserContacts(Integer userId,String txt);
}
