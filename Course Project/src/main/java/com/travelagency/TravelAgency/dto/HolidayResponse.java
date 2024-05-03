package com.travelagency.TravelAgency.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class HolidayResponse {
  private int id;
  private int duration;
  private int freeSlots;
  private double price;
  private LocationResponse location;
  private String title;
  private LocalDate startDate;
}
