package com.travelagency.TravelAgency.repository;

import com.travelagency.TravelAgency.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LocationRepository extends JpaRepository<Location,Long> , JpaSpecificationExecutor<Location> {

}
