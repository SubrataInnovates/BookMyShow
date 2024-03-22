package com.bookmyshow.entity;

import com.bookmyshow.enums.SeatType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowSeat 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer showSeatId;
	private String seatNo;
	@Enumerated(value = EnumType.STRING)
	private SeatType seatType;
	private Integer price;
	private Boolean isAvailable;
	@JoinColumn
	@ManyToOne
	private Show show;
}
