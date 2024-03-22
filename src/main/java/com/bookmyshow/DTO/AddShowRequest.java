package com.bookmyshow.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@Data
public class AddShowRequest {
    private LocalTime showTime;
    private LocalDate showDate;
    private String movieName;
    private Integer theaterId;
}
