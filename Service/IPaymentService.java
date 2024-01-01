package com.car_rent.service;

import java.sql.SQLException;

import com.car_rent.entity.Lease;

public interface IPaymentService {
	public int recordPayment(Lease lease, double amount) throws SQLException, ClassNotFoundException;

}
