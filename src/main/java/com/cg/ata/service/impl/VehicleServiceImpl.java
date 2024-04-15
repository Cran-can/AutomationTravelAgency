package com.cg.ata.service.impl;

import com.cg.ata.exception.VehicleNotFoundException;
import com.cg.ata.model.Vehicle;
import com.cg.ata.repository.VehicleRepository;
import com.cg.ata.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;
    @Override
    public void addVehicle(Vehicle vehicle) {
         vehicleRepository.save(vehicle);
    }

    @Override
    public void updateVehicle(Long vehicleId, Vehicle vehicle) {
        Vehicle obj = vehicleRepository.findById(vehicleId).orElseThrow(
                ()-> new VehicleNotFoundException("Vehicle not exist in database with id :"+vehicleId));
        obj.setVehicleType(vehicle.getVehicleType());
        obj.setVehicleNo(vehicle.getVehicleNo());
        obj.setVehicleName(vehicle.getVehicleName());
        obj.setSeatingCapacity(vehicle.getSeatingCapacity());
        obj.setVehicleType(vehicle.getVehicleType());
        obj.setFarePerKm(vehicle.getFarePerKm());

        Vehicle updatedVehicle =vehicleRepository.save(obj);
    }


    @Override
    public void deleteVehicle(Long vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow(
                ()-> new VehicleNotFoundException("Vehicle not found with id : "+vehicleId));
        vehicleRepository.deleteById(vehicleId);
    }

    @Override
    public Vehicle viewVehicle(Long vehicleId) {
        return vehicleRepository.findById(vehicleId).orElseThrow(
                ()-> new VehicleNotFoundException("Vehicle not found with id : "+vehicleId));
    }

    @Override
    public List<Vehicle> viewAllVehicles() {
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if(vehicleList.size()>0)
            return vehicleList;
        else
            throw new VehicleNotFoundException("No vehicles found in database");
    }
}
