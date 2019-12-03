package com.vehicle.vehicle.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="BUS")
public class Bus extends Vehicle{

    @Column(name="licenseType")
    private String licenseType;
    @Column(name="numSeats")
    private int numSeats;


    public Bus() {}

    public Bus(String make, String model, Integer year, int numDoors, String status, double price, String imgPath,
               String description, String licenseType, int numSeats) {
        super(make, model, year, numDoors, status, price, imgPath, description);
        this.licenseType = licenseType;
        this.numSeats = numSeats;
    }

    public int getNumSeats() {
        return numSeats;
    }

    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
    }

    public String getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }

    @Override
    public String toString() {
        return super.toString() + "Bus{" +
                "numSeats=" + numSeats +
                ", licenseType='" + licenseType + '\'' +
                '}';
    }
}