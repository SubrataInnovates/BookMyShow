package com.bookmyshow.entity;

import com.bookmyshow.enums.SeatType;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TheaterSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer theaterSeatId;

    
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Seat number must be alphanumeric")
    private String seatNo;

    @Nonnull
    @Enumerated(EnumType.STRING)
    private SeatType seatType;

    @NotNull
    @JoinColumn
    @ManyToOne
    private Theater theater;
}
