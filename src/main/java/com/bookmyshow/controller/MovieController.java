package com.bookmyshow.controller;

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
	
	@PostMapping("/addMovie")
	public String addMovie(@RequestBody Movie movie)
	{
		String addMovie = movieService.addMovie(movie);
		return addMovie;
	}
	
	@PutMapping("/updateMovie")
	public String updateMovieAttribute(@RequestBody UpdateMovieRequest movieRequest)
	{
		String updateMovieAttribute = movieService.updateMovieAttribute(movieRequest);
		return updateMovieAttribute;
	}
	
}
