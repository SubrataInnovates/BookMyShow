package com.bookmyshow.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmyshow.DTO.AddShowRequest;
import com.bookmyshow.DTO.AddShowSeatsRequest;
import com.bookmyshow.service.ShowService;

@RestController
@RequestMapping("/shows")
public class ShowController {

    @Autowired
    private ShowService showService;
    
    private static final Logger logger = LoggerFactory.getLogger(ShowController.class);
    
    @PostMapping("/addShow")
    public ResponseEntity addShow(@RequestBody AddShowRequest addShowRequest) {
        try {
            String addShow = showService.addShow(addShowRequest);
            logger.info("Show is added to db : {}", addShow);
            return new ResponseEntity(addShow, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error occurred while adding show: {}", e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    @PostMapping("/addShowSeat")
    public ResponseEntity addShowSeat(@RequestBody AddShowSeatsRequest addShowSeatsRequest) {
        try {
            String addShowSeats = showService.addShowSeats(addShowSeatsRequest);
            logger.info("Show Seats are added to db: {}", addShowSeats);
            return new ResponseEntity(addShowSeats, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error occurred while adding show seats: {}", e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
