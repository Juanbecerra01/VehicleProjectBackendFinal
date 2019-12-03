package com.vehicle.vehicle.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "VEH_TYPE")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Sedan.class, name = "SEDAN"),
        @JsonSubTypes.Type(value = Bus.class, name = "BUS"),
        @JsonSubTypes.Type(value = Coupe.class, name = "COUPE"),
        @JsonSubTypes.Type(value = Hatch.class, name = "HATCH"),
        @JsonSubTypes.Type(value = SUV.class, name = "SUV"),
        @JsonSubTypes.Type(value = Van.class, name = "VAN")
})
@Entity
@Table(name="Vehicle")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="VEH_TYPE", discriminatorType=DiscriminatorType.STRING)
public abstract class Vehicle{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="make")
    private String make;
    @Column(name="model")
    private String model;
    @Column(name="year")
    private Integer year;
    @Column(name="numDoors")
    private int numDoors;
    @Column(name="status")
    private String status;
    @Column(name="price")
    private double price;
    @Column(name="imgPath")
    private String imgPath;
    @Column(name="description")
    private String description;
    
    public Vehicle() {}

    public Vehicle(String make, String model, Integer year, int numDoors,
                   String status, double price, String imgPath, String description) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.numDoors = numDoors;
        this.status = status;
        this.price = price;
        this.imgPath = imgPath;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    
    public Integer getYear(){
        return year;
    }
    
    public void setYear(Integer year){
        this.year = year;
    }

    public int getNumDoors() {
        return numDoors;
    }

    public void setNumDoors(int numDoors) {
        this.numDoors = numDoors;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id='" + id + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", numDoors=" + numDoors +
                ", status='" + status + '\'' +
                ", price=" + price +
                '}';
    }
}