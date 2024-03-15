package com.bookmyshow.service;

import com.bookmyshow.DTO.AddTheaterRequest;
import com.bookmyshow.DTO.AddTheaterSeatsRequest;
import com.bookmyshow.entity.Theater;

public interface TheaterService 
{
	public String addTheater(AddTheaterRequest addTheaterRequest);
	public String AddTheaterSeats(AddTheaterSeatsRequest addTheaterSeatsRequest);

}
