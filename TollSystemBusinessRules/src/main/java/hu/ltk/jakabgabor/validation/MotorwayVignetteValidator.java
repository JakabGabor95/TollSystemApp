package hu.ltk.jakabgabor.validation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import hu.ltk.jakabgabor.entity.Vehicle;
import hu.ltk.jakabgabor.exception.InvalidRegistrationNumberException;
import hu.ltk.jakabgabor.exception.InvalidVehicleException;

public class MotorwayVignetteValidator {
    Gson gson = new Gson();

    public void validateByRegistrationNumber(String registrationNumber) {
        try {
            gson.fromJson(registrationNumber, Object.class);
        } catch (Exception e) {
            throw new InvalidRegistrationNumberException();
        }
    }

    public void validateVehicleJson(String vehicleJson) throws InvalidVehicleException {
        try {
            gson.fromJson(vehicleJson, Object.class);
        } catch (Exception e) {
            throw new InvalidVehicleException();
        }
    }

    public void checkVehicleIsNull(Vehicle vehicle) {
        try {
            if(vehicle == null){
                throw new InvalidVehicleException();
            }
        } catch (InvalidVehicleException e) {
            e.printStackTrace();
        }
    }
}
