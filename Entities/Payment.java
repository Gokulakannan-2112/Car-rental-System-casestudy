package com.car_rent.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Payment {
	
	private int paymentID;
	private LocalDate paymentDate;
	private double amount;
	private Lease lease;
	
	public Payment() {
		super();
	}

	public Payment(int paymentID, LocalDate paymentDate, double amount, Lease lease) {
		super();
		this.paymentID = paymentID;
		this.paymentDate = paymentDate;
		this.amount = amount;
		this.lease = lease;
	}

	public Payment( LocalDate paymentDate, double amount,Lease lease) {
		super();
		this.paymentDate = paymentDate;
		this.amount = amount;
		this.lease = lease;
		
	}

	public Payment(int paymentID, LocalDate paymentDate) {
		this.paymentID =paymentID;
		this.paymentDate = paymentDate;
	}

	public int getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Lease getLease() {
		return lease;
	}

	public void setLease(Lease lease) {
		this.lease = lease;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, lease, paymentDate, paymentID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
				&& Objects.equals(lease, other.lease) && Objects.equals(paymentDate, other.paymentDate)
				&& paymentID == other.paymentID;
	}

	@Override
	public String toString() {
		return "Payment [paymentID=" + paymentID + ", paymentDate=" + paymentDate + ", amount=" + amount + ", lease="
				+ lease + "]";
	}
	
	
	
	
}
