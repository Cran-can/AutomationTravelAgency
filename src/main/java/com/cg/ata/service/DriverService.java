package com.cg.ata.service;

import com.cg.ata.model.Driver;

import java.util.List;

public interface DriverService {
    public void addDriver(Driver driver);
    public void updateDriver(Long deiverId,Driver driver);
    public void deleteDriver(Long driverId);
    public Driver viewDriver(Long driverId);
    public List<Driver> viewAllDrivers();
}
