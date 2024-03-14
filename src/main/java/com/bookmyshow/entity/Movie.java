package com.bookmyshow.entity;

import java.time.LocalDate;

import com.bookmyshow.enums.Genre;
import com.bookmyshow.enums.Language;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer movieId;
	private String movieName;
	private double duration;
	@Enumerated(value = EnumType.STRING)
	private Genre genre;
	private LocalDate releseDate;
	private double rating;
	@Enumerated(value = EnumType.STRING)
	private Language language;
}
