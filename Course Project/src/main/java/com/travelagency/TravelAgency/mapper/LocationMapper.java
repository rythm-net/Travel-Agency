package com.travelagency.TravelAgency.mapper;

import com.travelagency.TravelAgency.dto.LocationRequest;
import com.travelagency.TravelAgency.dto.LocationResponse;
import com.travelagency.TravelAgency.entity.Location;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LocationMapper {

  List<LocationResponse> fromLocationListToLocationResponseList(List<Location> locationList);
  LocationResponse fromLocationToLocationResponse(Location location);
  Location fromLocationRequestToLocation(LocationRequest locationRequest);
}
