package com.travelagency.TravelAgency.service;

import com.travelagency.TravelAgency.dto.HolidayRequest;
import com.travelagency.TravelAgency.dto.HolidayResponse;
import com.travelagency.TravelAgency.entity.Holiday;
import com.travelagency.TravelAgency.mapper.HolidayMapper;
import com.travelagency.TravelAgency.repository.HolidayRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class HolidayService {
  private final HolidayRepository holidayRepository;
  private final HolidayMapper holidayMapper;
  private final LocationService locationService;
  public HolidayResponse addHoliday(HolidayRequest holidayRequest) {
    final var holiday = Holiday.builder()
      .duration(holidayRequest.getDuration())
      .freeSlots(holidayRequest.getFreeSlots())
      .price(holidayRequest.getPrice())
      .location(locationService.getLocationByIdForHoliday(holidayRequest.getLocationId()))
      .title(holidayRequest.getTitle())
      .startDate(holidayRequest.getStartDate()).build();

    return holidayMapper.fromHolidayToHolidayResponse(holidayRepository.save(holiday));
  }

  public List<HolidayResponse> getAllHolidays() {
    return holidayMapper.fromHolidayListToHolidayResponseList(holidayRepository.findAll());
  }

  public HolidayResponse getHolidayById(Long id) {
    final var holiday = holidayRepository.findById(id).orElseThrow(()-> {
      throw new RuntimeException();
    });

    return holidayMapper.fromHolidayToHolidayResponse(holiday);
  }

  public HolidayResponse updateHoliday(Long id, HolidayRequest holidayRequest) {
    final var holiday = holidayRepository.findById(id).orElseThrow(()-> {
      throw new RuntimeException();
    });

    holiday.builder()
           .duration(holidayRequest.getDuration())
           .freeSlots(holidayRequest.getFreeSlots())
           .price(holidayRequest.getPrice())
           .location(locationService.getLocationByIdForHoliday(holidayRequest.getLocationId()))
           .title(holidayRequest.getTitle())
           .startDate(holidayRequest.getStartDate()).build();

    return holidayMapper.fromHolidayToHolidayResponse(holiday);
  }

  public HolidayResponse deleteHoliday(Long id) {
    final var holiday = holidayRepository.findById(id).orElseThrow(() -> {
      throw new RuntimeException();
    });

    holidayRepository.deleteById(id);

    return holidayMapper.fromHolidayToHolidayResponse(holiday);
  }

  public Holiday getHolidayByIdForReservation(Long id){

    return holidayRepository.findById(id).orElseThrow(()-> {
      throw new RuntimeException();
    });
  }
}
