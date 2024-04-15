package com.cg.ata.controller;

import com.cg.ata.model.Vehicle;
import com.cg.ata.service.impl.VehicleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/vehicle")
public class VehicleController {

    @Autowired
    private VehicleServiceImpl  vehicleService;

    @PostMapping("/add")
    ResponseEntity<String> addVehicle(@RequestBody Vehicle vehicle) {
        vehicleService.addVehicle(vehicle);
        return ResponseEntity.ok("Vehicle Added");
    }
    @PutMapping("/update/{vehicleId}")
    ResponseEntity<String> updateVehicle(@PathVariable Long vehicleId, @RequestBody Vehicle vehicle) {
        vehicleService.updateVehicle(vehicleId, vehicle);
        return ResponseEntity.ok("Vehicle Updated");
    }
    @DeleteMapping("/delete/{vehicleId}")
    ResponseEntity<String> deleteVehicle(@PathVariable Long vehicleId) {
        vehicleService.deleteVehicle(vehicleId);
        return ResponseEntity.ok("Vehicle Deleted");
    }
    @GetMapping("/view/{vehicleId}")
    ResponseEntity<Vehicle> viewVehicle(@PathVariable Long vehicleId) {
        Vehicle vehicle = vehicleService.viewVehicle(vehicleId);
        return ResponseEntity.ok(vehicle);

    }
    @GetMapping("/viewAll")
    ResponseEntity<List<Vehicle>> viewAllVehicles() {
        List<Vehicle> vehicleList = vehicleService.viewAllVehicles();
        return ResponseEntity.ok(vehicleList);

    }
}
