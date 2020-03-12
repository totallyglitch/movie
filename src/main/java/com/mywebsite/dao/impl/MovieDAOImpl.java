package com.mywebsite.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mywebsite.dao.MovieDAO;
import com.mywebsite.model.Movie;

public class MovieDAOImpl extends BaseDAOImpl implements MovieDAO {

	private String mappedClass = "Movie";
	
	private static final Logger logger = LoggerFactory.getLogger(MovieDAOImpl.class);

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Movie> getSearchResults(String name, int limit) throws HibernateException {
		Session session = this.sessionFactory.openSession();
		logger.info("Fetching all AttendanceReport from "+mappedClass);
		String sql = "FROM "+mappedClass+" WHERE Name LIKE '"+name+"%'";
		Query query = session.createQuery(sql);
		List<Movie> movies = (List<Movie>)query.setMaxResults(limit).list();
		session.close();
		return movies;
	}

	@Override
	public int addMovie(String name) throws HibernateException {
		Movie m = new Movie();
		m.setName(name);
		return getMovieById(insert(m)).getRowId();
	}

	@Override
	public Movie getMovieById(int id) throws HibernateException {
		HashMap<String , Object> map = new HashMap<String , Object>();
		map.put("Id", id);
		logger.info("Id : "+id);
		return (Movie)get(mappedClass, map);
	}

}
