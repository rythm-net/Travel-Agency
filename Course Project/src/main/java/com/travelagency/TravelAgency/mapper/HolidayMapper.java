package com.travelagency.TravelAgency.mapper;

import com.travelagency.TravelAgency.dto.HolidayRequest;
import com.travelagency.TravelAgency.dto.HolidayResponse;
import com.travelagency.TravelAgency.entity.Holiday;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HolidayMapper {
  HolidayResponse fromHolidayToHolidayResponse(Holiday holiday);
  List<HolidayResponse> fromHolidayListToHolidayResponseList(List<Holiday> holidays);
}
