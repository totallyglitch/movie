package com.mywebsite.route;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.HibernateException;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mywebsite.common.Constants;
import com.mywebsite.common.Endpoints;
import com.mywebsite.dao.MovieDAO;
import com.mywebsite.model.Movie;
import com.mywebsite.util.InputValidation;
import com.mywebsite.util.InputVerification;
import com.mywebsite.util.JsonUtil;

@Path(Endpoints.MOVIE)
public class MovieEp {

	@Autowired
	MovieDAO movieDAO;

	private static final Logger logger = LoggerFactory.getLogger(MovieEp.class);

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@SuppressWarnings("unchecked")
	public Response addMovie(String json, @Context final HttpServletRequest request,
			@Context final HttpServletResponse response) {
		JSONObject jsonMap = new JSONObject();
		try {
			JSONObject result = JsonUtil.getJsonObject(json);

			String name = InputValidation.getString(InputVerification.get("movie", result));

			int id = this.movieDAO.addMovie(name);
			jsonMap.put("r_c", Constants.JsonResponse.OK);
			jsonMap.put("movie_id", id);
			return Response.status(Response.Status.OK).entity(jsonMap.toString()).build();
		} catch (HibernateException e) {
			logger.error(e.getMessage());
			jsonMap.clear();
			jsonMap.put("r_c", Constants.JsonResponse.SERVER_ERROR);
			jsonMap.put("msg", Constants.JsonResponse.SERVER_ERROR_MSG);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(jsonMap.toString()).build();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			jsonMap.clear();
			jsonMap.put("r_c", Constants.JsonResponse.SERVER_ERROR);
			jsonMap.put("msg", e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(jsonMap.toString()).build();
		}
	}

	@Path("/search/{name}/{limit}")
	@GET
	@SuppressWarnings("unchecked")
	public Response searchMovie(@PathParam("name") String name, @PathParam("limit") int limit,
			@Context final HttpServletRequest request, @Context final HttpServletResponse response) {
		JSONObject jsonMap = new JSONObject();
		try {

			List<Movie> mList = this.movieDAO.getSearchResults(name, limit);
			List<String> l = new ArrayList<String>();
			for (Movie m : mList) {
				l.add(m.getName());
			}
			System.out.println(l);
			return Response.status(Response.Status.OK).entity(Arrays.toString(l.toArray())).build();
		} catch (HibernateException e) {
			logger.error(e.getMessage());
			jsonMap.clear();

			jsonMap.put("r_c", Constants.JsonResponse.SERVER_ERROR);
			jsonMap.put("msg", Constants.JsonResponse.SERVER_ERROR_MSG);

			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(jsonMap.toString()).build();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			jsonMap.clear();
			jsonMap.put("r_c", Constants.JsonResponse.SERVER_ERROR);
			jsonMap.put("msg", e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(jsonMap.toString()).build();
		}
	}

}
