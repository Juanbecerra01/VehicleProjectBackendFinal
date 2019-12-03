package com.vehicle.vehicle.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="SUV")
public class SUV extends Vehicle {
    
    @Column(name="towingCapacity")
    private double towingCapacity;
    
    public SUV() {}

    public SUV(String make, String model, Integer year, int numDoors, String status,
               double price, String imgPath, String description, double towingCapacity) {
        super(make, model, year, numDoors, status, price, imgPath, description);
        this.towingCapacity = towingCapacity;
    }

    public double getTowingCapacity() {
        return this.towingCapacity;
    }
    
    public void setTowingCapacity(double towingCapacity) {
        this.towingCapacity = towingCapacity;
    }

    @Override
    public String toString() {
        return super.toString() + "SUV{" +
                "towingCapacity=" + towingCapacity +
                '}';
    }
}