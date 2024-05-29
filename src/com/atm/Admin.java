package com.atm;


public class Admin {

	private final String login = "admin";
	private final String motDePasse = "admin";
	private SqlQueries host = null;
	Admin(String cin) {
		host = new SqlQueries("admin");
		// TODO Auto-generated constructor stub
	}
	public String getLogin() {
		return login;
	}
//	public void setLogin(String login) {
//		this.login = login;
//	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public SqlQueries getSql() {
		return host;
	}
//	public void setMotDePasse(String motDePasse) {
//		this.motDePasse = motDePasse;
//	}
	
	
}
