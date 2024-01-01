package com.car_rent.service;

import java.sql.SQLException;

import com.car_rent.dao.IPaymentDAO;
import com.car_rent.entity.Lease;

public class PaymentServiceImpl implements IPaymentService {
	
	private IPaymentDAO iPaymentDAO;

	public PaymentServiceImpl(IPaymentDAO iPaymentDAO) {
		super();
		this.iPaymentDAO = iPaymentDAO;
	}

	public PaymentServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int recordPayment(Lease lease, double amount) throws SQLException, ClassNotFoundException {
		int result = 0;
		try {
			result = iPaymentDAO.recordPayment(lease, amount);
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Looks like JDBC driver is NOT loaded.");
		}catch(SQLException se) {
			System.out.println("Either url, username or password is wrong or duplicate record");
		}
		return result;
	}

}
