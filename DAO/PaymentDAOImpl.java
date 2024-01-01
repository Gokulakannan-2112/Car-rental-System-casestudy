package com.car_rent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.car_rent.entity.Lease;
import com.car_rent.entity.Payment;
import com.car_rent.util.DBUtil;

public class PaymentDAOImpl implements IPaymentDAO {
	
	private static Connection connCustomer;
	
	@Override
	public int recordPayment(Lease lease, double amount) throws SQLException, ClassNotFoundException {
		
		Payment payment = null;
	    int paymentID= 0;
		
		
		LocalDate paymentDate = null;
		
		connCustomer = DBUtil.createConnection();
		String query = "INSERT INTO payment(paymentDate, amount, leaseID) "+ 
		"VALUES(?,?,?)";
		
		PreparedStatement prepareStPayment = connCustomer.prepareStatement(query);
		prepareStPayment.setDouble(1, amount);
		prepareStPayment.setInt(2,lease.getLease());


		ResultSet rsPayment = prepareStPayment.executeQuery();

		while (rsPayment.next()) {// Till there are further records.
			paymentID = rsPayment.getInt("paymentId");
		    paymentDate = rsPayment.getDate("paymentDate").toLocalDate();

			 
		    payment = new Payment(paymentID, paymentDate);
		  }

		  int result = prepareStPayment.executeUpdate();
		  System.out.println(payment);
		  DBUtil.closeConnection();
		  return result;

	}

}

