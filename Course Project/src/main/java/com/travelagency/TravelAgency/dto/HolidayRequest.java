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
public class HolidayRequest {
  private int duration;
  private int freeSlots;
  private double price;
  private Long locationId;
  private String title;
  private LocalDate startDate;
}
