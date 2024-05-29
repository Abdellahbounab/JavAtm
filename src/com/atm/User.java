package com.atm;


public class User extends Person {

	private String login;
	private String motDePasse;
	private Account compteBancaire = null;
	private SqlQueries host = null;
	
	User(Person me, String login, String password) {
		super(me.getCIN(), me.getName(), me.getPrenom(), me.getGendre(), me.getNationality());
		this.login = login;
		this.motDePasse = password;
		host = new SqlQueries(login);
		// TODO Auto-generated constructor stub
	}
	public String getLogin() {
		return login;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void resetMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	public void setAccount(Account prs) {
		compteBancaire = prs;
	}
	public void setAccount(double solde, String type) {
		compteBancaire = new Account(login, solde, type);
	}
	public Account getAccount() {
		return compteBancaire;
	}
	public SqlQueries getSql() {
		return host;
	}
	public String toString() {
		return "'" + super.getCIN() + "', '" + login + "', '" + motDePasse + "'";
	}
	public Person getPerson() {
		return (Person)this;
	}
}
