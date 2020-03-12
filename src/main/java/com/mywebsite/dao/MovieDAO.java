package com.mywebsite.dao;

import java.util.List;

import org.hibernate.HibernateException;

import com.mywebsite.model.Movie;

public interface MovieDAO extends BaseDAO {
	
	public Movie getMovieById(int id) throws HibernateException;

	public List<Movie> getSearchResults(String name, int limit) throws HibernateException;

	public int addMovie(String name) throws HibernateException;

}
