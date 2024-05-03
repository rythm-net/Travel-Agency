package com.travelagency.TravelAgency.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "holiday")
public class Holiday {
  private int duration;
  @Column(name = "free_slots")
  private int freeSlots;
  private double price;
  @OneToOne
  @JoinColumn(name = "location_id")
  private Location location;
  @Id
  @GenericGenerator(name = "gen")
  @GeneratedValue(generator = "gen")
  private Long id;
  private String title;
  @Column(name = "start_date")
  private LocalDate startDate;
}
