package com.contactapp.services;

import com.contactapp.dao.BaseDao;
import com.contactapp.dao.ContactDao;
import com.contactapp.domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gazi_muhib on 8/18/17.
 */

@Service
public class ContactServiceImpl extends BaseDao implements ContactService {

    @Autowired
    ContactDao contactDao;

    public void save(Contact c) {
        contactDao.save(c);
    }

    public void update(Contact c) {
        contactDao.update(c);
    }

    public void delete(Integer contactid) {
        contactDao.delete(contactid);
    }

    public void delete(Integer[] contactIds) {
        for (Integer i:contactIds){
            contactDao.delete(i);
        }
    }

    public List<Contact> findUserContacts(Integer userId) {
        return contactDao.findByColumn("userId",userId);
    }

    public List<Contact> findUserContacts(Integer userId, String txt) {
        return null;
    }
}
