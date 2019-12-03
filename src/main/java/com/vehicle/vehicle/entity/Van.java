package com.vehicle.vehicle.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="VAN")
public class Van extends Vehicle {

    @Column(name="licenseType")
    private String licenseType;
    @Column(name="numSeats")
    private int numSeats;

    public Van(){}

    public Van(String make, String model, Integer year, int numDoors, String status, double price,
               String imgPath, String description, String licenseType, int numSeats) {
        super(make, model, year, numDoors, status, price, imgPath, description);
        this.licenseType = licenseType;
        this.numSeats = numSeats;
    }

    public String getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }

    public int getNumSeats() {
        return numSeats;
    }

    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
    }

    @Override
    public String toString() {
        return super.toString() + "Van{" +
                "licenseType='" + licenseType + '\'' +
                ", numSeats=" + numSeats +
                '}';
    }
}