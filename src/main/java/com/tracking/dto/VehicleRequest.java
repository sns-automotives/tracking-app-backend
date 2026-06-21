package com.tracking.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class VehicleRequest {
    private String vehicleNo;
    private String licenseNumber;
    private String companyName;
    private String ownerName;
    private String mobileNo;
    private String address;
    private LocalDate licenseFromDate;
    private LocalDate licenseToDate;
    private BigDecimal advanceAmount;
    private BigDecimal totalAmount;
    private String status;

    public String getVehicleNo() { return vehicleNo; }
    public void setVehicleNo(String vehicleNo) { this.vehicleNo = vehicleNo; }

    public String getLicenseNumber() { return licenseNumber; }
    public void setLicenseNumber(String licenseNumber) { this.licenseNumber = licenseNumber; }

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }

    public String getMobileNo() { return mobileNo; }
    public void setMobileNo(String mobileNo) { this.mobileNo = mobileNo; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public LocalDate getLicenseFromDate() { return licenseFromDate; }
    public void setLicenseFromDate(LocalDate licenseFromDate) { this.licenseFromDate = licenseFromDate; }

    public LocalDate getLicenseToDate() { return licenseToDate; }
    public void setLicenseToDate(LocalDate licenseToDate) { this.licenseToDate = licenseToDate; }

    public BigDecimal getAdvanceAmount() { return advanceAmount; }
    public void setAdvanceAmount(BigDecimal advanceAmount) { this.advanceAmount = advanceAmount; }

    public BigDecimal getTotalAmount() { return totalAmount; }
    public void setTotalAmount(BigDecimal totalAmount) { this.totalAmount = totalAmount; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
