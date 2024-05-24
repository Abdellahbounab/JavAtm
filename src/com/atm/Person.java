package com.atm;

import java.util.Date;

public class Person {
	private String CIN;
	private	String name;
	private	String prenom;
	private	String gendre;
	private	String address;
	private	String villeDeNaissance;
	private	String nationality;
	private Date dateNaissance;
	
	Person (String cin, String nom, String gend, String add, Date naissance, String villeNaiss, String nation){
		CIN = cin;
		name = nom;
		gendre = gend;
		address = add;
		dateNaissance = naissance;
		villeDeNaissance = villeNaiss;
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

	public String getAddress() {
		return address;
	}

	public String getVilleDeNaissance() {
		return villeDeNaissance;
	}

	public String getNationality() {
		return nationality;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}
	
}
