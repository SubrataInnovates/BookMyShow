package com.bookmyshow.service;

import com.bookmyshow.DTO.BookTicketRequest;

public interface TicketService
{
	public String bookTicket(BookTicketRequest bookTicketRequest) throws Exception;
}
