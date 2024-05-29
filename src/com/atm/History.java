package com.atm;

import java.text.NumberFormat;
import java.util.Locale;

public class History{

	String idAccount;
	String operation;
	double amount;
	History(String id, String operation, double amount){
		this.idAccount = id;
		this.operation = operation;
		this.amount = amount;
	}
	public String getOperation() {
		return operation;
	}
	public double getAmount() {
		return amount;
	}
	public String getIdAccount() {
		return idAccount;
	}
	public String[] archived(){
		return new String[]{getIdAccount(), NumberFormat.getCurrencyInstance(new Locale("fr", "MA")).format(getAmount()), getOperation()};
	}
}
