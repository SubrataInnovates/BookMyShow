package com.bookmyshow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmyshow.DTO.AddTheaterRequest;
import com.bookmyshow.DTO.AddTheaterSeatsRequest;
import com.bookmyshow.service.TheaterService;

@RestController
@RequestMapping("/theater")
public class TheatherController 
{
	@Autowired
	private TheaterService theaterService;
	
	
	@PostMapping("/addTheater")
	public ResponseEntity addTheater(@RequestBody AddTheaterRequest addTheaterRequest)
	{
		String addTheater = theaterService.addTheater(addTheaterRequest);
		return new ResponseEntity(addTheater,HttpStatus.OK);
	}
	@PostMapping("/addTheaterSeats")
	public ResponseEntity addTheaterSeats(@RequestBody AddTheaterSeatsRequest addTheaterSeatsRequest)
	{
		String addTheaterSeats = theaterService.addTheaterSeats(addTheaterSeatsRequest);
		return new ResponseEntity(addTheaterSeats,HttpStatus.OK);
	}
}
