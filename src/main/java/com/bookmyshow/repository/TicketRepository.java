package com.bookmyshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmyshow.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, String>
{

}
