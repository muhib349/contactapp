package com.contactapp.dao;

import com.contactapp.domain.Contact;
import com.contactapp.rowmapper.ContactRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gazi_muhib on 8/18/17.
 */

@Repository
public class ContactDaoImpl extends BaseDao implements ContactDao {
    public void save(Contact c) {

        String sql="INSERT INTO contact(userId,name,phone,email,address,remark) " +
                "VALUES(:userId,:name,:phone,:email,:address,:remark)";

        Map map=new HashMap();

        map.put("userId",c.getUser_id());
        map.put("name",c.getName());
        map.put("phone",c.getPhone());
        map.put("email",c.getEmail());
        map.put("address",c.getAddress());
        map.put("remark",c.getRemark());

        SqlParameterSource ps=new MapSqlParameterSource(map);

        KeyHolder key=new GeneratedKeyHolder();
        getNamedParameterJdbcTemplate().update(sql,ps,key);

        c.setContact_id(key.getKey().intValue());

    }

    public void update(Contact c) {
        String sql="UPDATE contact SET " +
                "name=:name," +
                "phone=:phone," +
                "email=:email," +
                "address=:address," +
                "remark=:remark" +
                " WHERE contactId=:contactId";

        Map map=new HashMap();

        map.put("name",c.getName());
        map.put("phone",c.getName());
        map.put("email",c.getName());
        map.put("address",c.getName());
        map.put("remark",c.getName());
        map.put("contactId",c.getContact_id());

        getNamedParameterJdbcTemplate().update(sql,map);

    }

    public void delete(Contact c) {
        this.delete(c.getContact_id());
    }

    public void delete(Integer contactId) {
        String sql="DELETE FROM contact WHERE contactId=?";

        getJdbcTemplate().update(sql,contactId);
    }

    public Contact findById(Integer contactId) {

        String sql="SELECT contactId,userId,name,phone,email,address,remark" +
                " FROM contact WHERE contactId=?";
        return getJdbcTemplate().queryForObject(sql,new ContactRowMapper(),contactId);
    }

    public List<Contact> findAll() {
        String sql="SELECT contactId,userId,name,phone,email,address,remark" +
                " FROM contact";

        return getJdbcTemplate().query(sql,new ContactRowMapper());
    }

    public List<Contact> findByColumn(String columnName, Object value) {
        String sql="SELECT contactId,userId,name,phone,email,address,remark" +
                " FROM contact WHERE "+columnName+"=?";

        return getJdbcTemplate().query(sql,new ContactRowMapper(),value);
    }
}
