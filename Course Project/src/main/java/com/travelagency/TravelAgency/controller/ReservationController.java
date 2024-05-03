package com.travelagency.TravelAgency.controller;

import com.travelagency.TravelAgency.dto.HolidayRequest;
import com.travelagency.TravelAgency.dto.HolidayResponse;
import com.travelagency.TravelAgency.dto.ReservationRequest;
import com.travelagency.TravelAgency.dto.ReservationResponse;
import com.travelagency.TravelAgency.service.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
public class ReservationController {
  private final ReservationService reservationService;

  @PostMapping("/reservations")
  public ResponseEntity<Void> addReservation(@RequestBody ReservationRequest reservationRequest){
    final var addedReservation = reservationService.addReservation(reservationRequest);

    URI location = UriComponentsBuilder
      .fromUriString("/locations/{id}")
      .buildAndExpand(addedReservation.getId())
      .toUri();

    return ResponseEntity.created(location).build();
  }

  @GetMapping("/reservations")
  public ResponseEntity<List<ReservationResponse>> getAllReservations(){
    return ResponseEntity.ok(reservationService.getAllReservations());
  }
  @GetMapping(value = "/reservations/{id}")
  public ResponseEntity<ReservationResponse> getReservationById(@PathVariable Long id){

    return ResponseEntity.ok(reservationService.getReservationById(id));
  }
  @PutMapping("/reservations/{id}")
  private ResponseEntity<ReservationResponse> updateReservation(
    @RequestBody ReservationRequest reservationRequest,
    @PathVariable Long id){

    return ResponseEntity.ok(reservationService.updateReservation(id , reservationRequest));
  }

  @DeleteMapping("/reservations/{id}")
  private ResponseEntity<ReservationResponse> deleteReservation(@PathVariable Long id){
    return ResponseEntity.ok(reservationService.deleteReservation(id));
  }
}
