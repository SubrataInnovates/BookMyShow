package com.bookmyshow.service;

import com.bookmyshow.DTO.UpdateMovieRequest;
import com.bookmyshow.entity.Movie;

public interface MovieService 
{
	public String addMovie(Movie movie);
	public String updateMovieAttribute(UpdateMovieRequest movieRequest);
}
