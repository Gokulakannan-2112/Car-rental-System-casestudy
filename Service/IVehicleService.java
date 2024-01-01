package com.carrent.service;

import java.util.List;
import com.carrent.entity.Vehicle;

public interface IVehicleService {
    public int addVehicle(Vehicle vehicle) throws Exception;
    public int updateVehicle(Vehicle vehicle) throws Exception;
    public int deleteVehicle(int vehicleId) throws Exception;
    public Vehicle viewVehicle(int vehicleId) throws Exception;
    public List<Vehicle> viewVehicles() throws Exception;
	int updateVehicle(int vehicle) throws Exception;
}