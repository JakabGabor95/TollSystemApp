package hu.ltk.jakabgabor.dto;

import hu.ltk.jakabgabor.entity.MotorwayVignette;
import hu.ltk.jakabgabor.entity.Vehicle;

import java.util.List;

public class MotorwayVignetteDTO {
    private Vehicle vehicle;
    private List<MotorwayVignette> motorwayVignetteList;

    public MotorwayVignetteDTO(Vehicle vehicle, List<MotorwayVignette> motorwayVignetteList) {
        this.vehicle = vehicle;
        this.motorwayVignetteList = motorwayVignetteList;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public List<MotorwayVignette> getMotorwayVignetteList() {
        return motorwayVignetteList;
    }

    public void setMotorwayVignetteList(List<MotorwayVignette> motorwayVignetteList) {
        this.motorwayVignetteList = motorwayVignetteList;
    }
}
