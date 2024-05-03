package com.travelagency.TravelAgency.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class LocationResponse {
  private int id;
  private int number;
  private String country;
  private String city;
  private String street;
  private String imageUrl;
}
