package com.travelagency.TravelAgency.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "location")
public class Location {
  private int number;
  private String country;
  private String city;
  private String street;
  private String imageUrl;
  @Id
  @GenericGenerator(name = "gen")
  @GeneratedValue(generator = "gen")
  private Long id;
}
