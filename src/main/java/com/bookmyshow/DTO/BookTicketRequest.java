package com.bookmyshow.DTO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import lombok.Data;

@Data
public class BookTicketRequest 
{
	private String movieName;
	private LocalDate showDate;
	private LocalTime showTime;
	private List<String> requestedSeats;
	private Integer theaterId;
	private String mobNo;
}
