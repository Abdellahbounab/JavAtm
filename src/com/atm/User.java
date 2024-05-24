package com.atm;

import java.util.Date;

public class User extends Person {

	private String login;
	private String motDePasse;
	User(String cin, String nom, String gend, String add, Date naissance, String villeNaiss, String nation) {
		super(cin, nom, gend, add, naissance, villeNaiss, nation);
		// TODO Auto-generated constructor stub
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
}
