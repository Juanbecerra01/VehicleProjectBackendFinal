package com.vehicle.vehicle.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="COUPE")
public class Coupe extends Vehicle {
    public Coupe() {}

    public Coupe(String make, String model, Integer year, int numDoors, String status, double price, String imgPath, String description) {
        super(make, model, year, numDoors, status, price, imgPath, description);
    }
}