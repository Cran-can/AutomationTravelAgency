package com.cg.ata.service;

import com.cg.ata.model.Vehicle;

import java.util.List;

public interface VehicleService {
    public void addVehicle(Vehicle vehicle);
    public void updateVehicle(Long vehicleId,Vehicle vehicle);
    public void deleteVehicle(Long vehicleId);
    public Vehicle viewVehicle(Long vehicleId);
    public List<Vehicle> viewAllVehicles();
}
