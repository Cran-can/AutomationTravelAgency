package com.cg.ata.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    private Date bookingDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date journeyDate;
    private String boardingPoint;
    private String dropPoint;
    private String contactNo;
    private double fare;
}
