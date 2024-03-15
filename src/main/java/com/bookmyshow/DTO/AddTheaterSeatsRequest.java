package com.bookmyshow.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddTheaterSeatsRequest 
{
	private int noOfClassicSeats;
	private int noOfPremiumSeats;
	private int theaterId;
}
