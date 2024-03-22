package com.bookmyshow.service;

import com.bookmyshow.DTO.AddShowRequest;
import com.bookmyshow.DTO.AddShowSeatsRequest;

public interface ShowService {
    String addShow(AddShowRequest addShowRequest);
    String addShowSeats(AddShowSeatsRequest addShowSeatsRequest);
}
