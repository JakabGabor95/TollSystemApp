package hu.ltk.jakabgabor.parser;

import com.google.gson.*;
import hu.ltk.jakabgabor.dto.MotorwayVignetteDTO;
import hu.ltk.jakabgabor.dto.RegistrationNumberResponseDTO;
import hu.ltk.jakabgabor.entity.Vehicle;

import java.time.LocalDate;

public class MotorwayVignetteParser {
    private static final Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, (JsonDeserializer<LocalDate>) (json, type, jsonDeserializationContext) -> LocalDate.parse(json.getAsJsonPrimitive().getAsString())).create();

    public RegistrationNumberResponseDTO parseToRegistrationNumber(String registrationNumber){
        return  gson.fromJson(registrationNumber, RegistrationNumberResponseDTO.class);
    }
    public Vehicle parseJsonToVehicle(String vehicleJson) {
        return gson.fromJson(vehicleJson, Vehicle.class);
    }

    public String parseMotorwayVignetteDTOToJson(MotorwayVignetteDTO motorwayVignetteDTO) {
        return gson.toJson(motorwayVignetteDTO);
    }
}
