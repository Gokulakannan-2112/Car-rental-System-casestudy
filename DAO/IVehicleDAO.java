package com.carrent.dao;

import java.sql.SQLException;
import java.util.List;
import com.carrent.entity.Vehicle;
import com.carrent.exception.VehicleNotFoundException;

public interface IVehicleDAO {
    int addVehicle(Vehicle vehicle) throws Exception;
    int updateVehicle(Vehicle vehicle) throws Exception;
    int deleteVehicle(int vehicleId) throws Exception; // Add this method
    Vehicle viewVehicle(int vehicleId) throws Exception; // Add this method
    List<Vehicle> viewVehicles() throws Exception;
	List<Vehicle> listAvailableVehicles() throws ClassNotFoundException, SQLException, VehicleNotFoundException;
	Vehicle findVehicleById(int vehicleID) throws ClassNotFoundException, SQLException, VehicleNotFoundException;
	int removeVehicle(int vehicleID) throws ClassNotFoundException, SQLException, VehicleNotFoundException;
	List<Vehicle> listRentedVehicles() throws ClassNotFoundException, SQLException, VehicleNotFoundException;
}