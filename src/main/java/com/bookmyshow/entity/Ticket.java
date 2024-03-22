package com.bookmyshow.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ticket
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String ticketId;

    @NotBlank(message = "Movie name is required")
    private String movieName;

    @NotNull(message = "Show date is required")
    private LocalDate showDate;

    @NotNull(message = "Show time is required")
    private LocalTime showTime;

    @NotBlank(message = "Theater name and address are required")
    private String theaterNameAndAddress;

    @NotNull(message = "Total amount paid is required")
    @Positive(message = "Total amount paid must be positive")
    private Integer totalAmountPaid;

    @NotNull(message = "User is required")
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}



