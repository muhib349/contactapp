package com.contactapp.rowmapper;

import com.contactapp.domain.Contact;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by gazi_muhib on 8/17/17.
 */
public class ContactRowMapper implements RowMapper<Contact> {
    public Contact mapRow(ResultSet resultSet, int i) throws SQLException {
        Contact c=new Contact();

        c.setContact_id(resultSet.getInt("contactId"));
        c.setUser_id(resultSet.getInt("userId"));
        c.setName(resultSet.getString("name"));
        c.setPhone(resultSet.getString("phone"));
        c.setEmail(resultSet.getString("email"));
        c.setAddress(resultSet.getString("address"));
        c.setRemark(resultSet.getString("remark"));

        return c;
    }
}
