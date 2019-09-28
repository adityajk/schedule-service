package com.makeathon.outliers.scheduleservice.service;

import com.makeathon.outliers.scheduleservice.entity.Booking;
import com.makeathon.outliers.scheduleservice.repository.BookingRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ScheduleService {

  private final BookingRepository bookingRepository;

  @Scheduled(fixedRate = 10000, initialDelay = 5000)
  public void readTimeFromRepo() {

    Date sD = new Date();

    Date d = new Date();
    // List<Booking> bookings = bookingRepository.findByStartDateAndStartTimeEndTimeBetween(d, d, d, new Date(d.getTime() + 10000));

    SimpleDateFormat df = new SimpleDateFormat("dd:mm:yyy");
    //Date dTest = new Date();

    SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
    String dateInString = "28-09-2019 03:32:56";
    Date dTest = null;
    try {
      dTest = sdf.parse(dateInString);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    List<Booking> bookings = bookingRepository.findByStartDateAndStartTimeEndTimeBetween(dTest, dTest, dTest, dTest);

    if(bookings.size() > 0) {
      System.out.println(bookings.stream()
          .distinct().findFirst().get().getId());
    } else {
      System.out.println("No Boooking Found !!");
    }


  }
}
