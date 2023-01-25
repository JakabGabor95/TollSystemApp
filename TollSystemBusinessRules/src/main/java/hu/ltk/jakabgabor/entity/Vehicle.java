package hu.ltk.jakabgabor.entity;

public class Vehicle {
    private String registrationNumber;
    private String make;
    private int numberOfSeats;
    private String vehicleType;

    public Vehicle(String registrationNumber, String make, int numberOfSeats, String vehicleType) {
        this.registrationNumber = registrationNumber;
        this.make = make;
        this.numberOfSeats = numberOfSeats;
        this.vehicleType = vehicleType;
    }
}
