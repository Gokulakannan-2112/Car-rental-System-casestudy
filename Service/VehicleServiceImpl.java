package com.carrent.service;

import java.util.List;

import com.carrent.dao.IVehicleDAO;
import com.carrent.dao.VehicleDAOImpl;
import com.carrent.entity.Vehicle;

public class VehicleServiceImpl implements IVehicleService {

    private IVehicleDAO vehicleDAO;

    public VehicleServiceImpl() {
        this.vehicleDAO = new VehicleDAOImpl();
    }

    @Override
    public int addVehicle(Vehicle vehicle) {
        int result = 0;
        try {
            result = vehicleDAO.addVehicle(vehicle);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updateVehicle(Vehicle vehicle) {
        int result = 0;
        try {
            result = vehicleDAO.updateVehicle(vehicle);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int deleteVehicle(int vehicleId) {
        int result = 0;
        try {
            result = vehicleDAO.deleteVehicle(vehicleId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Vehicle viewVehicle(int vehicleId) {
        Vehicle vehicle = null;
        try {
            vehicle = vehicleDAO.viewVehicle(vehicleId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vehicle;
    }

    @Override
    public List<Vehicle> viewVehicles() {
        List<Vehicle> vehicleList = null;
        try {
            vehicleList = vehicleDAO.viewVehicles();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vehicleList;
    }

    public int updateVehicleById(int vehicleId) throws Exception {
        // TODO Auto-generated method stub
        return 0;
    }

	@Override
	public int updateVehicle(int vehicle) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
}