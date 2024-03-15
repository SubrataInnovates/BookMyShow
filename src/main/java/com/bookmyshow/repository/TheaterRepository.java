package com.bookmyshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmyshow.entity.Theater;

public interface TheaterRepository extends JpaRepository<Theater,Integer>
{

}
