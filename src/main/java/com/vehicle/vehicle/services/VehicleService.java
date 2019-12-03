package com.vehicle.vehicle.services;

import com.vehicle.vehicle.entity.Vehicle;

import java.util.List;

public interface VehicleService{
    
    List<Vehicle> getVehicles();
    
    void saveVehicle(Vehicle vehicle);
    
    Vehicle getVehicle(int vehicleId);
    
    void deleteVehicle(int vehicleId);
    
}