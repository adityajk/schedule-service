package com.makeathon.outliers.scheduleservice.repository;

import com.makeathon.outliers.scheduleservice.entity.Booking;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

  @Query(value = "SELECT b FROM Booking b, BookingContent bc WHERE b.id=bc.booking"
      + " AND b.startDate >= ?1 AND b.endDate <= ?2 AND b.startTime <= ?3 AND b.startTime >= ?4")
  List<Booking> findByStartDateAndStartTimeEndTimeBetween(Date startDate, Date endDate,
      Date startTime, Date endTime);

  //@Query(value = "SELECT b FROM Booking b, BookingContent bc WHERE b.id=bc.booking"+ " AND b.startDate => ?1 AND b.startTime => ?2 AND b.endDate <= ?3 AND b.endTime <= ?4")
  // List<Booking> findBookings(Date now, Date now1, Date now2, Date now3);
}
