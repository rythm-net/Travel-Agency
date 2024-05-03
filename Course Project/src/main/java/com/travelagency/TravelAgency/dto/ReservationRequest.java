package com.travelagency.TravelAgency.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ReservationRequest {
  private String phoneNumber;
  private String contactName;
  private Long holidayId;
}
