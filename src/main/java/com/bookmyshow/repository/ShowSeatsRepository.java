package com.bookmyshow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bookmyshow.entity.Show;
import com.bookmyshow.entity.ShowSeat;

public interface ShowSeatsRepository extends JpaRepository<ShowSeat,Integer>
{
    public List<ShowSeat> findAllByShow(Show show);
    
    
    @Query(nativeQuery = true,value = "select * from show_seat where show_show_id = :showId")
    public List<ShowSeat> findShowSeats(Integer showId);
}

