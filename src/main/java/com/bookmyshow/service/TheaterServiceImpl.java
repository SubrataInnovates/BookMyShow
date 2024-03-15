package com.bookmyshow.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmyshow.DTO.AddTheaterRequest;
import com.bookmyshow.DTO.AddTheaterSeatsRequest;
import com.bookmyshow.entity.Theater;
import com.bookmyshow.entity.Theater.TheaterBuilder;
import com.bookmyshow.entity.TheaterSeat;
import com.bookmyshow.enums.SeatType;
import com.bookmyshow.repository.TheaterRepository;
import com.bookmyshow.repository.TheaterSeatRepository;

@Service
public class TheaterServiceImpl implements TheaterService
{

	@Autowired
	private TheaterRepository repository;
	@Autowired
	private TheaterSeatRepository theaterSeatRepository;
	@Override
	public String addTheater(AddTheaterRequest addTheaterRequest)
	{
//		Theater theater=new Theater();
//		theater.setName(addTheaterRequest.getName());
//		theater.setAddress(addTheaterRequest.getAddress());
//		theater.setNoOfScreens(addTheaterRequest.getNoOfScreens());
		
		Theater theater = Theater.builder()
				.address(addTheaterRequest.getAddress())
				.name(addTheaterRequest.getName())
				.noOfScreens(addTheaterRequest.getNoOfScreens()).build();
		
		
		
		Theater save = repository.save(theater);
		return "Theater is added in db " +save.getTheaterId();
	}
	@Override
    public String addTheaterSeats(AddTheaterSeatsRequest addTheaterSeatsRequest) {
        int noOfClassicSeats = addTheaterSeatsRequest.getNoOfClassicSeats();
        int noOfPremiumSeats = addTheaterSeatsRequest.getNoOfPremiumSeats();
        int theaterId = addTheaterSeatsRequest.getTheaterId();

        Theater theater = repository.findById(theaterId).orElse(null);

        if (theater == null) {
            return "Theater with ID " + theaterId + " not found.";
        }

        List<TheaterSeat> theaterSeats = new ArrayList<>();
        int classicSeatCount = 1;
        char ch = 'A';
        int rowNo = 1;

        // Generate classic seats
        while (classicSeatCount <= noOfClassicSeats) {
            String seatNo = rowNo + "" + ch;
            TheaterSeat theaterSeat = TheaterSeat.builder()
                    .seatNo(seatNo)
                    .seatType(SeatType.CLASSIC)
                    .theater(theater)
                    .build();

            theaterSeats.add(theaterSeat);

            ch++;

            if (classicSeatCount % 5 == 0) {
                rowNo++;
                ch = 'A';
            }

            classicSeatCount++;
        }

        int premiumSeatCount = 1;
        ch = 'A';

        // Increment rowNo for premium seats
        if (classicSeatCount % 5 != 1)
            rowNo++;

        // Generate premium seats
        while (premiumSeatCount <= noOfPremiumSeats) {
            String seatNo = rowNo + "" + ch;
            TheaterSeat theaterSeat = TheaterSeat.builder()
                    .seatNo(seatNo)
                    .seatType(SeatType.PREMIUM)
                    .theater(theater)
                    .build();

            theaterSeats.add(theaterSeat);

            ch++;

            if (premiumSeatCount % 5 == 0) {
                rowNo++;
                ch = 'A';
            }
            premiumSeatCount++;
        }

        List<TheaterSeat> savedTheaterSeats = theaterSeatRepository.saveAll(theaterSeats);

        return "Theater seats have been generated and saved.";
    }

}
