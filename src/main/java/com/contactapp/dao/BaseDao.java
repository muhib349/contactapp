package com.contactapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import javax.sql.DataSource;

/**
 * Created by gazi_muhib on 8/17/17.
 */
public abstract class BaseDao extends NamedParameterJdbcDaoSupport {

    @Autowired
    public void setDataSource2(DataSource ds){
        super.setDataSource(ds);

    }

}
