package com.travelagency.TravelAgency.controller;

import com.travelagency.TravelAgency.dto.LocationRequest;
import com.travelagency.TravelAgency.dto.LocationResponse;
import com.travelagency.TravelAgency.service.LocationService;
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
public class LocationController {
  private final LocationService locationService;

  @PostMapping("/locations")
  public ResponseEntity<Void> addLocation(@RequestBody LocationRequest locationRequest){
    LocationResponse addedLocation = locationService.addLocation(locationRequest);

    URI location = UriComponentsBuilder
      .fromUriString("/locations/{id}")
      .buildAndExpand(addedLocation.getId())
      .toUri();

    return ResponseEntity.created(location).build();
  }

  @GetMapping("/locations")
  public ResponseEntity<List<LocationResponse>> getAllLocations(){
    return ResponseEntity.ok(locationService.getAllLocations());
  }
  @GetMapping(value = "/locations/{id}")
  public ResponseEntity<LocationResponse> getLocationById(@PathVariable Long id){

    return ResponseEntity.ok(locationService.getLocationById(id));
  }

  @PutMapping("/locations/{id}")
  private ResponseEntity<LocationResponse> updateLocation(
    @RequestBody LocationRequest locationRequest,
    @PathVariable Long id){

    return ResponseEntity.ok(locationService.updateLocation(id , locationRequest));
  }

  @DeleteMapping("/location/{id}")
  private ResponseEntity<LocationResponse> deleteBrand(@PathVariable Long id){
    return ResponseEntity.ok(locationService.deleteLocation(id));
  }
}
