package com.tracking.repository;

import com.tracking.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query("SELECT v FROM Vehicle v WHERE " +
           "LOWER(v.vehicleNo) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
           "LOWER(v.companyName) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
           "LOWER(v.ownerName) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<Vehicle> searchByQuery(@Param("query") String query);
}
