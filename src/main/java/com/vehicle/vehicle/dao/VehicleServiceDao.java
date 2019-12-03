package com.vehicle.vehicle.dao;

import com.vehicle.vehicle.entity.Vehicle;

import java.util.List;

public interface VehicleServiceDao {
    
    List<Vehicle> getVehicles();
    
    void saveVehicle(Vehicle vehicle);
    
    Vehicle getVehicle(int vehicleId);
    
    void deleteVehicle(int vehicleId);
    
  
    
}