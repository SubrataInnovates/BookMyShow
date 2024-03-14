package com.bookmyshow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmyshow.DTO.UpdateMovieRequest;
import com.bookmyshow.entity.Movie;
import com.bookmyshow.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService
{
	@Autowired
	private MovieRepository movieRepository;

	@Override
	public String addMovie(Movie movie)
	{
		Movie save = movieRepository.save(movie);
		return "Movie has been added in DB "+save.getMovieId();
	}

	@Override
	public String updateMovieAttribute(UpdateMovieRequest movieRequest) 
	{
		Movie movie = movieRepository.findById(movieRequest.getMovieId()).get();
		
		double duration = movieRequest.getDuration();
		double rating = movieRequest.getRating();
		
		movie.setDuration(duration);
		movie.setRating(rating);
		return "Attribute are modified";
		
		
		
	}

}
