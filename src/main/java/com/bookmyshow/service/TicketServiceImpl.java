package com.bookmyshow.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmyshow.DTO.BookTicketRequest;
import com.bookmyshow.entity.Movie;
import com.bookmyshow.entity.Show;
import com.bookmyshow.entity.ShowSeat;
import com.bookmyshow.entity.Theater;
import com.bookmyshow.entity.Ticket;
import com.bookmyshow.entity.User;
import com.bookmyshow.exception.SeatUnavilableException;
import com.bookmyshow.repository.MovieRepository;
import com.bookmyshow.repository.ShowRepository;
import com.bookmyshow.repository.ShowSeatsRepository;
import com.bookmyshow.repository.TheaterRepository;
import com.bookmyshow.repository.TicketRepository;
import com.bookmyshow.repository.UserRepository;
@Service
public class TicketServiceImpl implements TicketService
{
	@Autowired
	private TicketRepository ticketRepository;
	@Autowired
	MovieRepository movieRepository;
	@Autowired
	TheaterRepository theaterRepository;
	@Autowired
	ShowRepository showRepository;

	@Autowired
	ShowSeatsRepository showSeatsRepository;
	@Autowired
	UserRepository userRepository;
	
//	@Override
//	public String bookTicket(BookTicketRequest bookTicketRequest) throws Exception
//	{
//		Movie movie = movieRepository.findMovieByMovieName(bookTicketRequest.getMovieName());
//		Theater theater = theaterRepository.findById(bookTicketRequest.getTheaterId()).get();
//		Show show = showRepository.findShowByShowDateAndShowTimeAndMovieAndTheater(bookTicketRequest.getShowDate(),
//				bookTicketRequest.getShowTime(),movie, theater);
//		
//		 if (show == null)
//		 {
//		        return "Show not found";
//		 }
//		
//		Integer showId = show.getShowId();
//		
//		List<ShowSeat> showSeatsList = showSeatsRepository.findShowSeats(showId);
//		
//		int totalMount=0;
//		Boolean areAllSeatsAvailable=Boolean.TRUE;
//		
//		for(String seatNo:bookTicketRequest.getRequestedSeats())
//		{
//			for(ShowSeat showSeat:showSeatsList)
//			{
//				if(showSeat.getSeatNo().equals(seatNo))
//				{
//					
//					if(showSeat.getIsAvailable()==Boolean.FALSE);
//					{
//						areAllSeatsAvailable=Boolean.FALSE;
//						break;
//					}
//					totalMount+=showSeat.getPrice();
//					
//				}
//				
//			}
//		}
//		
//		if(areAllSeatsAvailable==Boolean.FALSE)
//		{
//			throw new SeatUnavilableException("Seat is unavailable !!");
//		}
//		
//		for(String seatNo:bookTicketRequest.getRequestedSeats())
//		{
//			for(ShowSeat showSeat:showSeatsList)
//			{
//				if(showSeat.getSeatNo().equals(seatNo))
//				{
//					
//					showSeat.setIsAvailable(Boolean.FALSE);
//					
//				}
//				
//			}
//		}
//		User user = userRepository.findUserByMobNo(bookTicketRequest.getMobNo());
//		
//		Ticket ticket = Ticket.builder().user(user).movieName(bookTicketRequest.getMovieName()).showDate(bookTicketRequest.getShowDate())
//		.theaterNameAndAddress(theater.getName()+" "+theater.getAddress()).showTime(bookTicketRequest.getShowTime()).
//		totalAmountPaid(totalMount)
//		.build();
//		
//		ticket = ticketRepository.save(ticket);
//		return "Ticket is generated "+ticket.toString();
//		
//	}
	@Override
	public String bookTicket(BookTicketRequest bookTicketRequest) throws SeatUnavilableException {
	    Movie movie = movieRepository.findMovieByMovieName(bookTicketRequest.getMovieName());
	    Theater theater = theaterRepository.findById(bookTicketRequest.getTheaterId())
	                                      .orElseThrow(() -> new RuntimeException("Theater not found"));

	    Show show = showRepository.findShowByShowDateAndShowTimeAndMovieAndTheater(
	            bookTicketRequest.getShowDate(),
	            bookTicketRequest.getShowTime(),
	            movie,
	            theater
	    );

	    if (show == null) {
	        return "Show not found";
	    }

	    List<ShowSeat> showSeatsList = showSeatsRepository.findShowSeats(show.getShowId());

	    int totalAmount = 0;
	    boolean areAllSeatsAvailable = true;

	    for (String seatNo : bookTicketRequest.getRequestedSeats()) {
	        boolean seatFound = false;
	        for (ShowSeat showSeat : showSeatsList) {
	            if (showSeat.getSeatNo().equals(seatNo)) {
	                seatFound = true;
	                if (!showSeat.getIsAvailable()) {
	                    areAllSeatsAvailable = false;
	                    break;
	                }
	                totalAmount += showSeat.getPrice();
	                showSeat.setIsAvailable(false);
	                break;
	            }
	        }
	        if (!seatFound) {
	            throw new SeatUnavilableException("Invalid seat number: " + seatNo);
	        }
	    }

	    if (!areAllSeatsAvailable) {
	        throw new SeatUnavilableException("One or more seats are unavailable");
	    }

	    User user = userRepository.findUserByMobNo(bookTicketRequest.getMobNo());
	    if (user == null) {
	        throw new RuntimeException("User not found");
	    }

	    Ticket ticket = Ticket.builder()
	            .user(user)
	            .movieName(bookTicketRequest.getMovieName())
	            .showDate(bookTicketRequest.getShowDate())
	            .theaterNameAndAddress(theater.getName() + " " + theater.getAddress())
	            .showTime(bookTicketRequest.getShowTime())
	            .totalAmountPaid(totalAmount)
	            .build();

	    ticket = ticketRepository.save(ticket);
	    return "Ticket is generated: " + ticket.toString();
	}


	

}
