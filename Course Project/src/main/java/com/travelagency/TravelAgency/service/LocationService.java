package com.travelagency.TravelAgency.service;

import com.travelagency.TravelAgency.dto.LocationRequest;
import com.travelagency.TravelAgency.dto.LocationResponse;
import com.travelagency.TravelAgency.entity.Location;
import com.travelagency.TravelAgency.mapper.LocationMapper;
import com.travelagency.TravelAgency.repository.LocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LocationService {
  private final LocationRepository locationRepository;
  private final LocationMapper locationMapper;
  public LocationResponse addLocation(LocationRequest locationRequest) {
    Location location = locationMapper.fromLocationRequestToLocation(locationRequest);

    return locationMapper.fromLocationToLocationResponse(locationRepository.save(location));
  }

  public List<LocationResponse> getAllLocations() {
    return locationMapper.fromLocationListToLocationResponseList(locationRepository.findAll());
  }

  public LocationResponse getLocationById(Long id) {
    final var location = locationRepository.findById(id).orElseThrow(() -> {
      throw new RuntimeException();
    });
    return locationMapper.fromLocationToLocationResponse(location);
  }

  public LocationResponse updateLocation(Long id , LocationRequest locationRequest) {
    final var location = locationRepository.findById(id).orElseThrow(() -> {
      throw new RuntimeException();
    });

    location.setCountry(locationRequest.getCountry());
    location.setCity(locationRequest.getCity());
    location.setStreet(locationRequest.getStreet());
    location.setNumber(locationRequest.getNumber());
    location.setImageUrl(locationRequest.getImageUrl());

    final var updatedLocation = locationRepository.save(location);
    return locationMapper.fromLocationToLocationResponse(updatedLocation);
  }

  public LocationResponse deleteLocation(Long id) {
    final var location = locationRepository.findById(id).orElseThrow(() -> {
      throw new RuntimeException();
    });

    locationRepository.deleteById(id);

    return locationMapper.fromLocationToLocationResponse(location);
  }

  public Location getLocationByIdForHoliday(Long id){
    return locationRepository.findById(id).orElseThrow(() -> {
      throw new RuntimeException();
    });
  }
}
