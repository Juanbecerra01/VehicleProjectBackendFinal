package com.vehicle.vehicle.rest;

import com.vehicle.vehicle.entity.Vehicle;
import com.vehicle.vehicle.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:4200")
public class VehicleRestController {
    //     @PreAuthorize("hasRole('EMPLOYEE')")
    @Autowired
    private VehicleService vehicleService;
    
    @GetMapping("/vehicles")
    public List<Vehicle> getVehicles(){
        return vehicleService.getVehicles();
    }
    
    @GetMapping("/vehicles/{vehicleId}")
    public Vehicle getVehicle(@PathVariable int vehicleId) throws Exception {
        Vehicle vehicle = vehicleService.getVehicle(vehicleId);
        if(vehicle == null){
            throw new Exception("Vehicle not found");
        }
        return vehicle;
    }

    @PostMapping("/vehicles")
    public Vehicle addVehicle(@RequestBody Vehicle vehicle){
        vehicle.setId(0);
        vehicleService.saveVehicle(vehicle);
        return vehicle;
    }
    
    @PutMapping("/vehicles")
    public Vehicle updateVehicle(@RequestBody Vehicle vehicle){
        vehicleService.saveVehicle(vehicle);
        return vehicle;
    }
    
    @DeleteMapping("/vehicles/{vehicleId}")
    public void deleteVehicle(@PathVariable int vehicleId) throws Exception {
        Vehicle v = vehicleService.getVehicle(vehicleId);
        if(v == null) {
            throw new Exception("Error");
        }
        vehicleService.deleteVehicle(vehicleId);
    }
}