package com.atm;

public class Account {
	private String	idAccount;
	private	double	solde;
	private	String	type;
	Account(String id, double money){
		idAccount = id;
		solde = money;
	}
	public void setSolde(double fluss) {
		this.solde = fluss;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getIdAccount() {
		return idAccount;
	}
	public double getSolde() {
		return solde;
	}
	public void	deposeMoney(double money) {
		solde += money;
	}
}
