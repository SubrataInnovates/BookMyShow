package com.bookmyshow.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmyshow.DTO.AddShowRequest;
import com.bookmyshow.DTO.AddShowSeatsRequest;
import com.bookmyshow.entity.Movie;
import com.bookmyshow.entity.Show;
import com.bookmyshow.entity.ShowSeat;
import com.bookmyshow.entity.Theater;
import com.bookmyshow.entity.TheaterSeat;
import com.bookmyshow.enums.SeatType;
import com.bookmyshow.repository.MovieRepository;
import com.bookmyshow.repository.ShowRepository;
import com.bookmyshow.repository.ShowSeatsRepository;
import com.bookmyshow.repository.TheaterRepository;

@Service
public class ShowServiceImpl implements ShowService
{
	@Autowired
	private ShowRepository showRepository;
	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private TheaterRepository theaterRepository;
	@Autowired
	private ShowSeatsRepository showSeatsRepository;
	

	@Override
	public String addShow(AddShowRequest addShowRequest) {
	    Movie movie = movieRepository.findMovieByMovieName(addShowRequest.getMovieName());
	    Theater theater = theaterRepository.findById(addShowRequest.getTheaterId()).get();
	    
	    Show show = Show.builder()
	            .showDate(addShowRequest.getShowDate())
	            .showTime(addShowRequest.getShowTime())
	            .movie(movie)
	            .theater(theater)
	            .build();
	    Show save = showRepository.save(show);
	    
	    return "Show is added to db "+save.getShowId();
	}



	@Override
	public String addShowSeats(AddShowSeatsRequest addShowSeatsRequest) 
	{
		
		Integer showId = addShowSeatsRequest.getShowId();
		Show show = showRepository.findById(showId).get();
		Theater theater = show.getTheater();
		List<TheaterSeat> theaterSeatList=theater.getTheaterSeats();
		
		List<ShowSeat> showSeatList=new ArrayList<>();
		for(TheaterSeat theaterSeat:theaterSeatList)
		{
			ShowSeat showSeat = ShowSeat.builder().
			seatNo(theaterSeat.getSeatNo()).
			seatType(theaterSeat.getSeatType()).
			isAvailable(Boolean.TRUE).
			show(show).
			build();
			
			if(theaterSeat.getSeatType().equals(SeatType.CLASSIC))
			{
				showSeat.setPrice(addShowSeatsRequest.getPriceOfClassicSeats());
			}
			else {
				showSeat.setPrice(addShowSeatsRequest.getPriceOfPremiumSeats());
			}
			showSeatList.add(showSeat);
			
		}
		
		showSeatsRepository.saveAll(showSeatList);
		return "Show seats have been generated for the given showId";
	}	

}