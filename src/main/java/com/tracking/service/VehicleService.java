package com.tracking.service;

import com.tracking.dto.VehicleRequest;
import com.tracking.dto.VehicleResponse;
import com.tracking.entity.User;
import com.tracking.entity.Vehicle;
import com.tracking.repository.UserRepository;
import com.tracking.repository.VehicleRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final UserRepository userRepository;

    public VehicleService(VehicleRepository vehicleRepository, UserRepository userRepository) {
        this.vehicleRepository = vehicleRepository;
        this.userRepository = userRepository;
    }

    public VehicleResponse create(VehicleRequest request) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username).orElseThrow();

        Vehicle vehicle = new Vehicle();
        mapToVehicle(request, vehicle);
        vehicle.setCreatedBy(user);

        return mapToResponse(vehicleRepository.save(vehicle));
    }

    public VehicleResponse update(Long id, VehicleRequest request) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found with id: " + id));
        mapToVehicle(request, vehicle);
        return mapToResponse(vehicleRepository.save(vehicle));
    }

    public List<VehicleResponse> getAll() {
        return vehicleRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public VehicleResponse getById(Long id) {
        return mapToResponse(vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found with id: " + id)));
    }

    public List<VehicleResponse> search(String query) {
        return vehicleRepository.searchByQuery(query).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private void mapToVehicle(VehicleRequest request, Vehicle vehicle) {
        vehicle.setVehicleNo(request.getVehicleNo());
        vehicle.setLicenseNumber(request.getLicenseNumber());
        vehicle.setCompanyName(request.getCompanyName());
        vehicle.setOwnerName(request.getOwnerName());
        vehicle.setMobileNo(request.getMobileNo());
        vehicle.setAddress(request.getAddress());
        vehicle.setLicenseFromDate(request.getLicenseFromDate());
        vehicle.setLicenseToDate(request.getLicenseToDate());
        vehicle.setAdvanceAmount(request.getAdvanceAmount());
        vehicle.setTotalAmount(request.getTotalAmount());
        if (request.getStatus() != null) {
            vehicle.setStatus(request.getStatus());
        }
    }

    private VehicleResponse mapToResponse(Vehicle vehicle) {
        VehicleResponse res = new VehicleResponse();
        res.setId(vehicle.getId());
        res.setVehicleNo(vehicle.getVehicleNo());
        res.setLicenseNumber(vehicle.getLicenseNumber());
        res.setCompanyName(vehicle.getCompanyName());
        res.setOwnerName(vehicle.getOwnerName());
        res.setMobileNo(vehicle.getMobileNo());
        res.setAddress(vehicle.getAddress());
        res.setLicenseFromDate(vehicle.getLicenseFromDate());
        res.setLicenseToDate(vehicle.getLicenseToDate());
        res.setAdvanceAmount(vehicle.getAdvanceAmount());
        res.setTotalAmount(vehicle.getTotalAmount());
        res.setStatus(vehicle.getStatus());
        res.setCreatedBy(vehicle.getCreatedBy() != null ? vehicle.getCreatedBy().getUsername() : null);
        res.setCreatedAt(vehicle.getCreatedAt());
        res.setUpdatedAt(vehicle.getUpdatedAt());
        return res;
    }
}
