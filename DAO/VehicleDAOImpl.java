package com.carrent.dao;

import com.carrent.entity.Vehicle;
import com.carrent.exception.VehicleNotFoundException;
import com.carrent.util.DBUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAOImpl implements IVehicleDAO {
    private static Connection connVehicle;
    
    @Override
    public int addVehicle(Vehicle vehicle) throws ClassNotFoundException, SQLException {
        connVehicle = DBUtil.createConnection();
        String query = "INSERT INTO Vehicle (vehicleID, make, model, year, dailyRate, status, passengerCapacity, engineCapacity) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement prepareStVehicle = connVehicle.prepareStatement(query);
        prepareStVehicle.setInt(1, vehicle.getVehicleID());
        prepareStVehicle.setString(2, vehicle.getMake());
        prepareStVehicle.setString(3, vehicle.getModel());
        prepareStVehicle.setInt(4, vehicle.getYear());
        prepareStVehicle.setDouble(5, vehicle.getDailyRate());
        prepareStVehicle.setString(6, vehicle.getStatus());
        prepareStVehicle.setInt(7, vehicle.getPassengerCapacity());
        prepareStVehicle.setDouble(8, vehicle.getEngineCapacity());

        int result = prepareStVehicle.executeUpdate();

        DBUtil.closeConnection();
        return result;
    }
    
    @Override
    public int removeVehicle(int vehicleID) throws ClassNotFoundException, SQLException, VehicleNotFoundException {
        Vehicle vehicle = null;
        int result = 0;

        connVehicle = DBUtil.createConnection();

        String queryCheck = "SELECT * FROM Vehicle WHERE vehicleID = ?";
        String queryDelete = "DELETE FROM Vehicle WHERE vehicleID = ?";

        PreparedStatement prepareStVehicle = connVehicle.prepareStatement(queryCheck);
        PreparedStatement prepareVehicleDelete = connVehicle.prepareStatement(queryDelete);

        prepareStVehicle.setInt(1, vehicleID);
        prepareVehicleDelete.setInt(1, vehicleID);

        ResultSet rsVehicle = prepareStVehicle.executeQuery();

        while (rsVehicle.next()) {
            vehicle = new Vehicle(rsVehicle.getInt("vehicleID"), rsVehicle.getString("make"), rsVehicle.getString("model"), rsVehicle.getInt("year"), rsVehicle.getDouble("dailyRate"), rsVehicle.getString("status"), rsVehicle.getInt("passengerCapacity"), rsVehicle.getDouble("engineCapacity"));
        }

        if (vehicle == null) {
            throw new VehicleNotFoundException("No Vehicle Found");
        } else {
            result = prepareVehicleDelete.executeUpdate();
        }

        DBUtil.closeConnection();

        return result;
    }
    
    @Override
    public Vehicle findVehicleById(int vehicleID) throws ClassNotFoundException, SQLException, VehicleNotFoundException {
        Vehicle vehicle = null;

        connVehicle = DBUtil.createConnection();

        String query = "SELECT * FROM Vehicle WHERE vehicleID = ?";

        PreparedStatement prepareStVehicle = connVehicle.prepareStatement(query);

        prepareStVehicle.setInt(1, vehicleID);

        ResultSet rsVehicle = prepareStVehicle.executeQuery();

        while (rsVehicle.next()) {
            vehicle = new Vehicle(rsVehicle.getInt("vehicleID"), rsVehicle.getString("make"), rsVehicle.getString("model"), rsVehicle.getInt("year"), rsVehicle.getDouble("dailyRate"), rsVehicle.getString("status"), rsVehicle.getInt("passengerCapacity"), rsVehicle.getDouble("engineCapacity"));
        }

        DBUtil.closeConnection();

        if (vehicle == null) {
            throw new VehicleNotFoundException("No Vehicle Found");
        }

        return vehicle;
    }
    
    @Override
    public List<Vehicle> listAvailableVehicles() throws ClassNotFoundException, SQLException, VehicleNotFoundException {
        List<Vehicle> vehicles = new ArrayList<>();
        Vehicle vehicle = null;

        connVehicle = DBUtil.createConnection();

        String query = "SELECT * FROM Vehicle WHERE status = 'available'";

        PreparedStatement prepareStVehicle = connVehicle.prepareStatement(query);

        ResultSet rsVehicle = prepareStVehicle.executeQuery();

        while (rsVehicle.next()) {
            vehicle = new Vehicle(rsVehicle.getInt("vehicleID"), rsVehicle.getString("make"), rsVehicle.getString("model"), rsVehicle.getInt("year"), rsVehicle.getDouble("dailyRate"), rsVehicle.getString("status"), rsVehicle.getInt("passengerCapacity"), rsVehicle.getDouble("engineCapacity"));
            vehicles.add(vehicle);
        }
        DBUtil.closeConnection();

        if (vehicles.size() == 0) {
            throw new VehicleNotFoundException("No Vehicle Found");
        }

        return vehicles;
    }
    
    @Override
    public List<Vehicle> listRentedVehicles() throws ClassNotFoundException, SQLException, VehicleNotFoundException {
        List<Vehicle> vehicles = new ArrayList<>();
        Vehicle vehicle = null;

        connVehicle = DBUtil.createConnection();

        String query = "SELECT * FROM Vehicle WHERE status = 'rented'";

        PreparedStatement prepareStVehicle = connVehicle.prepareStatement(query);

        ResultSet rsVehicle = prepareStVehicle.executeQuery();

        while (rsVehicle.next()) {
            vehicle = new Vehicle(rsVehicle.getInt("vehicleID"), rsVehicle.getString("make"), rsVehicle.getString("model"), rsVehicle.getInt("year"), rsVehicle.getDouble("dailyRate"), rsVehicle.getString("status"), rsVehicle.getInt("passengerCapacity"), rsVehicle.getDouble("engineCapacity"));
            vehicles.add(vehicle);
        }
        DBUtil.closeConnection();

        if (vehicles.size() == 0) {
            throw new VehicleNotFoundException("No Vehicle Found");
        }

        return vehicles;
    }
    
    @Override
    public List<Vehicle> viewVehicles() throws ClassNotFoundException, SQLException {
        List<Vehicle> vehicles = new ArrayList<>();
        connVehicle = DBUtil.createConnection();

        String query = "SELECT * FROM Vehicle";

        PreparedStatement prepareStVehicle = connVehicle.prepareStatement(query);

        ResultSet rsVehicle = prepareStVehicle.executeQuery();

        while (rsVehicle.next()) {
            Vehicle vehicle = new Vehicle(rsVehicle.getInt("vehicleID"), rsVehicle.getString("make"), rsVehicle.getString("model"), rsVehicle.getInt("year"), rsVehicle.getDouble("dailyRate"), rsVehicle.getString("status"), rsVehicle.getInt("passengerCapacity"), rsVehicle.getDouble("engineCapacity"));
            vehicles.add(vehicle);
        }
        DBUtil.closeConnection();

        return vehicles;
    }
    
    @Override
    public int updateVehicle(Vehicle vehicle) throws ClassNotFoundException, SQLException {
        connVehicle = DBUtil.createConnection();

        String query = "UPDATE Vehicle SET make = ?, model = ?, year = ?, dailyRate = ?, status = ?, passengerCapacity = ?, engineCapacity = ? WHERE vehicleID = ?";

        PreparedStatement prepareStVehicle = connVehicle.prepareStatement(query);

        prepareStVehicle.setString(1, vehicle.getMake());
        prepareStVehicle.setString(2, vehicle.getModel());
        prepareStVehicle.setInt(3, vehicle.getYear());
        prepareStVehicle.setDouble(4, vehicle.getDailyRate());
        prepareStVehicle.setString(5, vehicle.getStatus());
        prepareStVehicle.setInt(6, vehicle.getPassengerCapacity());
        prepareStVehicle.setDouble(7, vehicle.getEngineCapacity());
        prepareStVehicle.setInt(8, vehicle.getVehicleID());

        int result = prepareStVehicle.executeUpdate();

        DBUtil.closeConnection();

        return result;
    }
    
    @Override
    public int deleteVehicle(int vehicleId) throws ClassNotFoundException, SQLException {
        connVehicle = DBUtil.createConnection();

        String query = "DELETE FROM Vehicle WHERE vehicleID = ?";

        PreparedStatement prepareStVehicle = connVehicle.prepareStatement(query);

        prepareStVehicle.setInt(1, vehicleId);

        int result = prepareStVehicle.executeUpdate();

        DBUtil.closeConnection();

        return result;
    }
    
    @Override
    public Vehicle viewVehicle(int vehicleId) throws ClassNotFoundException, SQLException, VehicleNotFoundException {
        Vehicle vehicle = null;

        connVehicle = DBUtil.createConnection();

        String query = "SELECT * FROM Vehicle WHERE vehicleID = ?";

        PreparedStatement prepareStVehicle = connVehicle.prepareStatement(query);

        prepareStVehicle.setInt(1, vehicleId);

        ResultSet rsVehicle = prepareStVehicle.executeQuery();

        while (rsVehicle.next()) {
            vehicle = new Vehicle(rsVehicle.getInt("vehicleID"), rsVehicle.getString("make"), rsVehicle.getString("model"), rsVehicle.getInt("year"), rsVehicle.getDouble("dailyRate"), rsVehicle.getString("status"), rsVehicle.getInt("passengerCapacity"), rsVehicle.getDouble("engineCapacity"));
        }

        DBUtil.closeConnection();

        if (vehicle == null) {
            throw new VehicleNotFoundException("No Vehicle Found");
        }

        return vehicle;
    }
    
}