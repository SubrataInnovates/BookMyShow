package com.bookmyshow.repository;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmyshow.entity.Movie;
import com.bookmyshow.entity.Show;
import com.bookmyshow.entity.Theater;

public interface ShowRepository extends JpaRepository<Show,Integer>
{
	public Show findShowByShowDateAndShowTimeAndMovieAndTheater(LocalDate showDate,LocalTime showTime,Movie movie,Theater theater);
}
