package com.travelagency.TravelAgency.controller;

import com.travelagency.TravelAgency.dto.HolidayRequest;
import com.travelagency.TravelAgency.dto.HolidayResponse;
import com.travelagency.TravelAgency.service.HolidayService;
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
public class HolidayController {

  private final HolidayService holidayService;

  @PostMapping("/holidays")
  public ResponseEntity<Void> addHoliday(@RequestBody HolidayRequest holidayRequest){
    final var addedHoliday = holidayService.addHoliday(holidayRequest);

    URI location = UriComponentsBuilder
      .fromUriString("/locations/{id}")
      .buildAndExpand(addedHoliday.getId())
      .toUri();

    return ResponseEntity.created(location).build();
  }

  @GetMapping("/holidays")
  public ResponseEntity<List<HolidayResponse>> getAllHolidays(){
    return ResponseEntity.ok(holidayService.getAllHolidays());
  }
  @GetMapping(value = "/holidays/{id}")
  public ResponseEntity<HolidayResponse> getHolidayById(@PathVariable Long id){

    return ResponseEntity.ok(holidayService.getHolidayById(id));
  }
  @PutMapping("/holidays/{id}")
  private ResponseEntity<HolidayResponse> updateHoliday(
    @RequestBody HolidayRequest holidayRequest,
    @PathVariable Long id){

    return ResponseEntity.ok(holidayService.updateHoliday(id , holidayRequest));
  }

  @DeleteMapping("/holidays/{id}")
  private ResponseEntity<HolidayResponse> deleteHoliday(@PathVariable Long id){
    return ResponseEntity.ok(holidayService.deleteHoliday(id));
  }
}
