package com.atm;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Account {
	private String	idAccount;
	private	double	solde;
	private	String	type;
	private SqlQueries root;
	private ArrayList<History> archive = new ArrayList<History>();
	Account(String id, double money, String type){
		idAccount = id;
		solde = money;
		this.type = type;
		root = new SqlQueries(id);
		archive.add(new History(idAccount, "Active", money));
	}
	public void retireSolde(double fluss) {
		solde -= fluss;
		archive.add(new History(idAccount, "Passive", fluss));
	}
	public void	deposeMoney(double money) {
		solde += money;
		archive.add(new History(idAccount, "Active", money));
	}
	public String getType() {
		return type;
	}
	public String getIdAccount() {
		return idAccount;
	}
	public double getSolde() {
		return solde;
	}
	public String toString() {
		return "'" + this.getIdAccount() + "', '" + this.getType() + "', " + this.getSolde();
	}
	public String[] toStrings() {
		return new String[]{this.getIdAccount(), NumberFormat.getCurrencyInstance(new Locale("fr", "MA")).format(getSolde()), this.getType()};
	}
}
