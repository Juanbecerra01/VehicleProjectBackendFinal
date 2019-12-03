package com.vehicle.vehicle.dao;

import com.vehicle.vehicle.entity.Vehicle;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
class VehicleServiceImlDao implements VehicleServiceDao {

    // define field for entityManger - entityManger is automatically created by spring boot
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public VehicleServiceImlDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Vehicle> getVehicles(){
        // Get the Hibernate Session
        Session session = entityManager.unwrap(Session.class);

        // Create a query
        Query<Vehicle> query =
                session.createQuery("from Vehicle", Vehicle.class);

        // execute query and convert to list
        List<Vehicle> list = query.getResultList();

        // return list
        return list;
    }

    @Override
    public void saveVehicle(Vehicle vehicle){
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(vehicle);
    }

    @Override
    public Vehicle getVehicle(int vehicleId){
        Session session = entityManager.unwrap(Session.class);
        //Using query
        /*
        Query<Vehicle> query = session.createQuery("from Vehicle v WHERE v.id = :vid", Vehicle.Class);
        query.setParameter("vid", vehicleId);
        Vehicle v = query.getVehicle();
        */

        //Using shortcut
        Vehicle vehicle = session.get(Vehicle.class, vehicleId);
        return vehicle;
    }

    @Override
    public void deleteVehicle(int vehicleId){
        Session session = entityManager.unwrap(Session.class);

        Query query = session.createQuery("delete from Vehicle WHERE id=:vid");
        query.setParameter("vid", vehicleId);

        query.executeUpdate();
    }
}