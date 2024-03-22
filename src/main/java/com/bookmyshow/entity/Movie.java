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
//import jakarta.validation.constraints.Max;
//import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.PastOrPresent;
//import jakarta.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieId;

    //@NotNull
    //@Size(min = 1, message = "Movie name must not be empty")
    private String movieName;

//    @NotNull
//    @Min(value = 1, message = "Duration must be greater than zero")
    private double duration;

//    @NotNull
    @Enumerated(value = EnumType.STRING)
    private Genre genre;

//    @NotNull
//    @PastOrPresent(message = "Release date must be in the past or present")
    private LocalDate releaseDate;

//    @NotNull
//    @Min(value = 0, message = "Rating must be greater than or equal to 0")
//    @Max(value = 10, message = "Rating must be less than or equal to 10")
    private double rating;

//    @NotNull
    @Enumerated(value = EnumType.STRING)
    private Language language;
}
