package com.travelagency.TravelAgency.mapper;

import com.travelagency.TravelAgency.dto.ReservationResponse;
import com.travelagency.TravelAgency.entity.Reservation;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservationMapper {
  ReservationResponse fromReservationToReservationResponse(Reservation reservation);
  List<ReservationResponse> fromReservationListToReservationResponseList(List<Reservation> reservations);
}
