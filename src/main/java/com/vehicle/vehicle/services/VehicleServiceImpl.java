package com.vehicle.vehicle.services;

import com.vehicle.vehicle.dao.VehicleServiceDao;
import com.vehicle.vehicle.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@CrossOrigin(origins = "http://localhost:4200")
public class VehicleServiceImpl implements VehicleService{
    
    @Autowired
    private VehicleServiceDao vehicleServiceDao;
    
    @Override
    public List<Vehicle> getVehicles(){
        return vehicleServiceDao.getVehicles();
    }

    @Override
    public void saveVehicle(Vehicle vehicle){
        vehicleServiceDao.saveVehicle(vehicle);
    }
    
    @Override
    public Vehicle getVehicle(int vehicleId){
        return vehicleServiceDao.getVehicle(vehicleId);
    }

    @Override
    public void deleteVehicle(int vehicleId){
        vehicleServiceDao.deleteVehicle(vehicleId);
        
    }
    
}