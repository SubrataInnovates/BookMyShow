package com.bookmyshow.controller;

import java.security.PublicKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmyshow.DTO.BookTicketRequest;
import com.bookmyshow.service.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController
{
	@Autowired
	TicketService ticketService;
	
	private static final Logger logger=LoggerFactory.getLogger(TicketController.class);
	@PostMapping("/bookTicket")
	public ResponseEntity bookTicket(@RequestBody BookTicketRequest bookTicketRequest)
	{
		try {
			String bookTicket = ticketService.bookTicket(bookTicketRequest);
			logger.info("Ticket generated  : {} "+bookTicket);
			return new ResponseEntity(bookTicket,HttpStatus.OK);
		} catch (Exception e) 
		{
			return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
