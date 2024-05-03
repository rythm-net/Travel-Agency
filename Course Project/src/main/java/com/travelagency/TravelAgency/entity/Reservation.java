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

import javax.naming.Name;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Table(name = "reservation")
@Entity
public class Reservation {
  @Column(name = "phone_number")
  private String phoneNumber;
  @Column(name = "contact_name")
  private String contactName;
  @Id
  @GenericGenerator(name = "gen")
  @GeneratedValue(generator = "gen")
  private Long id;
  @OneToOne
  @JoinColumn(name = "holiday_id")
  private Holiday holiday;

}
