package com.cg.ata.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicleId;

    private String vehicleNo;
    private String vehicleName;
    private int seatingCapacity;
    private String vehicleType;
    private double farePerKm;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;
}
