package com.mywebsite.dao;

import java.util.HashMap;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseDAO {
	public int insert(Object object) throws HibernateException;
	public Object get(String table, HashMap<String, Object> map) throws HibernateException;
}
