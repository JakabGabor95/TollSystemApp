package hu.ltk.jakabgabor;

import hu.ltk.jakabgabor.api.MotorwayVignetteRequestInterface;
import hu.ltk.jakabgabor.api.MotorwayVignetteResponseInterface;
import hu.ltk.jakabgabor.dto.MotorwayVignetteDTO;
import hu.ltk.jakabgabor.dto.RegistrationNumberResponseDTO;
import hu.ltk.jakabgabor.entity.MotorwayVignette;
import hu.ltk.jakabgabor.entity.Vehicle;
import hu.ltk.jakabgabor.interfaces.VehicleDisplayInterface;
import hu.ltk.jakabgabor.interfaces.VehicleRegisterInteractorInterface;
import hu.ltk.jakabgabor.parser.MotorwayVignetteParser;
import hu.ltk.jakabgabor.storage.MotorwayVignetteStorageInterface;
import hu.ltk.jakabgabor.validation.MotorwayVignetteValidator;

import java.util.List;

public class TollSystemRegister implements MotorwayVignetteRequestInterface, VehicleDisplayInterface {
    private Vehicle vehicle;
    MotorwayVignetteValidator motorwayVignetteValidator;
    MotorwayVignetteParser motorwayVignetteParser;
    VehicleRegisterInteractorInterface vehicleRegisterInteractor;
    MotorwayVignetteStorageInterface motorwayVignetteStorageInterface;
    MotorwayVignetteResponseInterface motorwayVignetteResponseInterface;
    public TollSystemRegister(MotorwayVignetteStorageInterface motorwayVignetteStorageInterface, MotorwayVignetteResponseInterface motorwayVignetteResponseInterface) {
        this.motorwayVignetteStorageInterface = motorwayVignetteStorageInterface;
        this.motorwayVignetteResponseInterface = motorwayVignetteResponseInterface;
        this.motorwayVignetteParser = new MotorwayVignetteParser();
        this.motorwayVignetteValidator =  new MotorwayVignetteValidator();
    }

    public TollSystemRegister(MotorwayVignetteStorageInterface motorwayVignetteStorageInterface) {
        this.motorwayVignetteStorageInterface = motorwayVignetteStorageInterface;

    }

    public void setVehicleRegisterInteractor(VehicleRegisterInteractorInterface vehicleRegisterInteractor) {
        this.vehicleRegisterInteractor = vehicleRegisterInteractor;
    }

    @Override
    public void findVehicleWithVignettesByRegistrationNumber(String registrationNumberJson) {
        motorwayVignetteValidator.validateByRegistrationNumber(registrationNumberJson);
        RegistrationNumberResponseDTO registrationNumberResponseDTO = motorwayVignetteParser
                .parseToRegistrationNumber(registrationNumberJson);
        vehicleRegisterInteractor.getVehicleByRegistrationNumber(registrationNumberResponseDTO.regNumber);
       List<MotorwayVignette> motorwayVignetteList =
               motorwayVignetteStorageInterface
                       .findByRegistrationNumber(registrationNumberResponseDTO.regNumber);
        MotorwayVignetteDTO motorwayVignetteDTO = new MotorwayVignetteDTO(vehicle, motorwayVignetteList);
        motorwayVignetteResponseInterface
                .display(motorwayVignetteParser.parseMotorwayVignetteDTOToJson(motorwayVignetteDTO));
    }


    @Override
    public void display(String vehicleJson) {
        motorwayVignetteValidator.validateVehicleJson(vehicleJson);
        vehicle = motorwayVignetteParser.parseJsonToVehicle(vehicleJson);
    }
}
