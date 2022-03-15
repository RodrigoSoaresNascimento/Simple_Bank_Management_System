package com.myBank;

public class Accounts {
	
	private String accountName;
	private int pinNumber;
	private double depositAmount;
	
	public Accounts(String accountName, int pinNumber, double depositAmount) {
		super();
		this.accountName = accountName;
		this.pinNumber = pinNumber;
		this.depositAmount = depositAmount;
	}
	
	public String getAccountName() {
		return accountName;
	}
	public int getPinNumber() {
		return pinNumber;
	}
	public double getDepositAmount() {
		return depositAmount;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public void setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
	}
	public void setDepositAmount(double depositAmount) {
		this.depositAmount = depositAmount;
	}

}
