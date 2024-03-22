package com.bookmyshow.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "shows")
public class Show
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer showId;
	private LocalDate showDate;
	private LocalTime showTime;
	@JoinColumn
    @ManyToOne
    private Movie movie;
    @JoinColumn
    @ManyToOne
    private Theater theater;
	

}
