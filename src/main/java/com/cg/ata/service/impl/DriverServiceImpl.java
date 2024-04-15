package com.cg.ata.service.impl;

import com.cg.ata.exception.DriverNotFoundException;
import com.cg.ata.model.Driver;
import com.cg.ata.repository.DriverRepository;
import com.cg.ata.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Override
    public void addDriver(Driver driver) {
        driverRepository.save(driver);
    }

    @Override
    public void updateDriver(Long driverId, Driver driver) {
        Driver obj = driverRepository.findById(driverId).orElseThrow(
                () -> new DriverNotFoundException(
                        "Driver not found with id : " + driverId));

        obj.setName(driver.getName());
        obj.setAddress(driver.getAddress());
        obj.setContactNo(driver.getContactNo());
        obj.setLicenseNo(driver.getLicenseNo());

        Driver updatedDriver = driverRepository.save(obj);

    }

    @Override
    public void deleteDriver(Long driverId) {
        Driver driver = driverRepository.findById(driverId).orElseThrow(
                () -> new DriverNotFoundException(
                        "Driver not found with id : " + driverId));

        driverRepository.deleteById(driverId);
    }

    @Override
    public Driver viewDriver(Long driverId) {
        return driverRepository.findById(driverId).orElseThrow(
                () -> new DriverNotFoundException(
                        "Driver not found with id : " + driverId));
    }

    @Override
    public List<Driver> viewAllDrivers() {
        List<Driver> driverList = driverRepository.findAll();
        if(driverList.size()>0)
            return driverList;
        else
            throw new DriverNotFoundException("No drivers found in database");
    }
}
