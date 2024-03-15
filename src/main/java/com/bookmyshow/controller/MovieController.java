package com.bookmyshow.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmyshow.DTO.UpdateMovieRequest;
import com.bookmyshow.entity.Movie;
import com.bookmyshow.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController 
{
	@Autowired
	private MovieService movieService;
	
	private static final Logger logger=LoggerFactory.getLogger(MovieController.class);
	
	@PostMapping("/addMovie")
	public String addMovie(@RequestBody Movie movie)
	{
		String addMovie = movieService.addMovie(movie);
		logger.info("Movie add controller : {} "+addMovie);
		return addMovie;
	}
	
	@PutMapping("/updateMovie")
	public String updateMovieAttribute(@RequestBody UpdateMovieRequest movieRequest)
	{
		String updateMovieAttribute = movieService.updateMovieAttribute(movieRequest);
		logger.info("updateMovieAttribute controller : {} "+updateMovieAttribute);
		return updateMovieAttribute;
	}
	
}
