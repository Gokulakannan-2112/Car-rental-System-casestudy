package com.car_rent.dao;

import java.sql.SQLException;

import com.car_rent.entity.Lease;

public interface IPaymentDAO {
	public int recordPayment(Lease lease, double amount) throws SQLException, ClassNotFoundException;

}
