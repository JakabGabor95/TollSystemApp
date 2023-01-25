package hu.ltk.jakabgabor.storage;

import hu.ltk.jakabgabor.entity.MotorwayVignette;

import java.util.List;

public interface MotorwayVignetteStorageInterface {
    List<MotorwayVignette> findByRegistrationNumber(String registrationNumber);
}
