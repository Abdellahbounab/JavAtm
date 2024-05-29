package com.atm;

public class Person {
	private String CIN;
	private	String name;
	private	String prenom;
	private	String gendre;
	private	String nationality;
	private SqlQueries host;
	
	Person (String cin, String nom, String prenom, String gend, String nation){
		CIN = cin;
		name = nom;
		this.prenom = prenom;
		gendre = gend;
		nationality = nation;
	}

	public String getCIN() {
		return CIN;
	}

	public String getName() {
		return name;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getGendre() {
		return gendre;
	}


	public String getNationality() {
		return nationality;
	}

	
	public SqlQueries getRoot() {
		return host;
	}
	
	public String toString() {
		return "'" + CIN + "', '" + name + "', '" + prenom + "', '" + gendre + "', '" + nationality + "'";
	}
	
}
