package com.travelagency.TravelAgency.service;

import com.travelagency.TravelAgency.dto.ReservationRequest;
import com.travelagency.TravelAgency.dto.ReservationResponse;
import com.travelagency.TravelAgency.entity.Reservation;
import com.travelagency.TravelAgency.mapper.ReservationMapper;
import com.travelagency.TravelAgency.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ReservationService {
  private final ReservationRepository reservationRepository;
  private final ReservationMapper reservationMapper;
  private final HolidayService holidayService;

  public ReservationResponse addReservation(ReservationRequest reservationRequest) {
    final var reservation = Reservation.builder()
      .phoneNumber(reservationRequest.getPhoneNumber())
      .contactName(reservationRequest.getContactName())
      .holiday(holidayService.getHolidayByIdForReservation(reservationRequest.getHolidayId())).build();

    reservationRepository.save(reservation);

    return reservationMapper.fromReservationToReservationResponse(reservation);
  }

  public List<ReservationResponse> getAllReservations() {
    return reservationMapper.fromReservationListToReservationResponseList(reservationRepository.findAll());
  }

  public ReservationResponse getReservationById(Long id) {
    final var reservation = reservationRepository.findById(id).orElseThrow(() -> {
      throw new RuntimeException();
    });

    return reservationMapper.fromReservationToReservationResponse(reservation);
  }

  public ReservationResponse updateReservation(Long id, ReservationRequest reservationRequest) {
    final var reservation = reservationRepository.findById(id).orElseThrow(() -> {
      throw new RuntimeException();
    });
    reservation.toBuilder()
      .phoneNumber(reservationRequest.getPhoneNumber())
      .contactName(reservationRequest.getContactName())
      .holiday(holidayService.getHolidayByIdForReservation(reservationRequest.getHolidayId())).build();

    return reservationMapper.fromReservationToReservationResponse(reservationRepository.save(reservation));
  }

  public ReservationResponse deleteReservation(Long id) {
    final var reservation = reservationRepository.findById(id).orElseThrow(() -> {
      throw new RuntimeException();
    });

    reservationRepository.deleteById(id);

    return reservationMapper.fromReservationToReservationResponse(reservation);
  }
}
