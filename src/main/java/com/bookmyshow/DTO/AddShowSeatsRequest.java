package com.bookmyshow.DTO;

import lombok.Data;

@Data
public class AddShowSeatsRequest 
{
	private Integer showId;
	private Integer priceOfClassicSeats;
	private Integer priceOfPremiumSeats;

}
