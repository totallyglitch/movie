package com.mywebsite.dao.impl;

import java.util.HashMap;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.mywebsite.dao.BaseDAO;

@Repository
public class BaseDAOImpl implements BaseDAO {

	public SessionFactory sessionFactory;

	private static final Logger logger = LoggerFactory.getLogger(BaseDAOImpl.class);

	@Override
	public int insert(Object object) throws HibernateException {
		logger.info("Inserting "+object.toString());
		Session session = this.sessionFactory.openSession();
		Transaction tx = null;
		Integer objectId = null;
		try {
			tx = session.beginTransaction();
			objectId = (Integer) session.save(object);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			throw e;
		} finally {
			session.close();
		}
		return objectId.intValue();
	}

	@Override
	public Object get(String table, HashMap<String, Object> map) throws HibernateException {
			logger.info("Fetching From "+table);
			Session session = this.sessionFactory.openSession();
			StringBuilder hql = new StringBuilder();
			hql.append(String.format("from %s WHERE ",table));
			Set<String> keys = map.keySet();
			for (String key : keys) {
				hql.append(String.format(key+" = '%s',",map.get(key)));
			}
			hql.deleteCharAt(hql.length() - 1);
	        Object object = session.createQuery(hql.toString()).uniqueResult();
	        session.close();
	        return object;
	}
}
