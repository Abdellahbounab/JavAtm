package com.atm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class SqlQueries {
	private String root;
	private SqlUtils sql = new SqlUtils();
	
	public SqlQueries(String login) {
		root = login;
	}
	
	public ArrayList<User> getUsers() {
		ArrayList<User> res = new ArrayList<User>();
		ResultSet myRs;
		try {
			sql.setResult(sql.connectedSql().executeQuery("SELECT * FROM account, user, person WHERE account.idAccount = user.idAccount AND person.CIN = user.CIN;"));
			myRs = sql.getResult();
			while (sql.getResult().next()) {
				res.add(new User(new Person(myRs.getString("CIN"), myRs.getString("nom"), myRs.getString("prenom"), 
						myRs.getString("gender"), myRs.getString("Nationality")),
						myRs.getString("idAccount"), myRs.getString("motDePasse")));
			}
		} catch (SQLException e) {e.printStackTrace();}
		try {sql.closeSqlAll();} catch (SQLException e) {e.printStackTrace();}
		return res;
	}
	
	public ArrayList<User> getHistory() {
		ArrayList<User> res = new ArrayList<User>();
		ResultSet myRs;
		try {
			sql.setResult(sql.connectedSql().executeQuery("SELECT * FROM account, user, history, person WHERE account.idAccount = user.idAccount AND person.CIN = user.CIN;"));
			myRs = sql.getResult();
			while (sql.getResult().next()) {
				res.add(new User(new Person(myRs.getString("CIN"), myRs.getString("nom"), myRs.getString("prenom"), 
						myRs.getString("gender"), myRs.getString("Nationality")),
						myRs.getString("idAccount"), myRs.getString("motDePasse")));
			}
		} catch (SQLException e) {e.printStackTrace();}
		try {sql.closeSqlAll();} catch (SQLException e) {e.printStackTrace();}
		return res;
	}
	
	public ArrayList<Person> getPersons() {
		ArrayList<Person> res = new ArrayList<Person>();
		ResultSet myRs;
		try {
			if (root.equals("admin") == false)
				return null;
			sql.setResult(sql.connectedSql().executeQuery("select * from person;"));
			myRs = sql.getResult();
			while (sql.getResult().next()) {
				res.add(new Person(myRs.getString("CIN"), myRs.getString("nom"), myRs.getString("prenom"), 
						myRs.getString("gender"), myRs.getString("Nationality")));
			}
		} catch (SQLException e) {e.printStackTrace();}
		try {sql.closeSqlAll();} catch (SQLException e) {e.printStackTrace();}
		return res;
	}
	
	public ArrayList<Account> getAccounts() {
		ArrayList<Account> res = new ArrayList<Account>();
		ResultSet myRs;
		try {
			if (root.equals("admin") == true) {
				sql.setResult(sql.connectedSql().executeQuery("SELECT * FROM account;"));
				myRs = sql.getResult();
				while (sql.getResult().next()) {
					res.add(new Account(myRs.getString("idAccount"), Double.parseDouble(myRs.getString("solde")), myRs.getString("type")));
				}
			}
		} catch (SQLException e) {e.printStackTrace();}
		try {sql.closeSqlAll();} catch (SQLException e) {e.printStackTrace();}
		return res;
	}
	
	public Account getAccount(User prs) {
		ArrayList<Account> res = this.getAccounts();
		for (Account ps : res) {
			if (ps.getIdAccount().equals(prs.getLogin()))
				return ps;
		}
		return null;
	}
	
	
	//this one to insert the everyone
	public int	insertPerson(Person per) {
		try {
			if (root.equals("admin") && this.checkPerson(per.getCIN()) == 0) {
//				System.out.println("insert into person values (" + per.toString() + ");");
				sql.connectedSql().executeUpdate("insert into person values (" + per.toString() + ");");
				sql.closeSqlAll();
				return 1;				
			}
		} catch (SQLException e) {e.printStackTrace(); System.out.println("Not inserted in Person");}
		return 0;
	}
	
	//this one to insert the user
	public int	insertUser(User per) {
		try {
			if (root.equals("admin") && this.checkPerson(per.getCIN()) == 1) {
//				System.out.println("insert into user values (" + per.toString() + ");");
				sql.connectedSql().executeUpdate("insert into user values (" + per.toString() + ");");
				sql.closeSqlAll();
				return 1;
			}
		} catch (SQLException e) {e.printStackTrace(); System.out.println("Not inserted in user");}
		return 0;
	}
	
	public int	insertAccount(Account per) {
		try {
			if (root.equals("admin")) {
//				System.out.println("insert into account values (" + per.toString() + ");");
				sql.connectedSql().executeUpdate("insert into account values (" + per.toString() + ");");
				sql.closeSqlAll();
				return 1;
			}
		} catch (SQLException e) {e.printStackTrace(); System.out.println("Not inserted in user");}
		return 0;
	}
	
	public int	deleteUser(String cin) {
		try {
			if (root.equals("admin")) {
				sql.connectedSql().executeUpdate("delete from user where CIN = '" + cin + "';");
				sql.closeSqlAll();
				return 1;				
			}
		} catch (SQLException e) {e.printStackTrace();}
		return 0;
	}

	public int updateUser(User prs) {
		try {
			sql.connectedSql().executeUpdate("update user set idAccount = '" + prs.getLogin() + "', motDePasse = '" + prs.getMotDePasse()+ "' where CIN = '" + prs.getCIN() + "';");
			sql.closeSqlAll();
			return 1;
		} catch (SQLException e) {e.printStackTrace();}
		return 0;
	}
	
	public int checkUser(String login, String mdp) {
		ArrayList<User> users = new ArrayList<User>();
		users = this.getUsers();
		for (User usr : users) {
			if (usr.getLogin().equals(login) && usr.getMotDePasse().equals(mdp))
				return 1;
		}
		return 0;
	}
	
	public int checkUser(String login) {
		ArrayList<User> users = new ArrayList<User>();
		users = this.getUsers();
		for (User usr : users) {
			if (usr.getLogin().equals(login))
				return 1;
		}
		return 0;
	}
	
	public int checkPerson(String cin) {
		ArrayList<Person> users = new ArrayList<Person>();
		users = this.getPersons();
		for (Person usr : users) {
			if (usr.getCIN().equals(cin))
				return 1;
		}
		return 0;
	}
	
	public User getUser(String log) {
		if (this.checkUser(log) != 0) {
			ArrayList<User> res = this.getUsers();
			for (User pr : res) {
				if (pr.getLogin().equals(log))
					return pr;
			}			
		}
		return null;
	}
	
	public int userCounter() {
		return this.getUsers().size();
	}
	
	public double soldeCounter(){
		double counter = 0;
		ArrayList<Account> us = new ArrayList<Account>();
		us = this.getAccounts();
		for (Account u : us) {
			counter += u.getSolde();
		}
		return counter;
	}
	
	public int updateAccount(Account prs) {
		try {
				sql.connectedSql().executeUpdate("update account set solde = " + prs.getSolde()+ " where idAccount = '" + prs.getIdAccount() + "';");
				sql.closeSqlAll();
				return 1;			
		} catch (SQLException e) {e.printStackTrace();}
		return 0;
	}
	
	public int updateAccount(String loginTo, double transf) {
		try {
				sql.connectedSql().executeUpdate("update account set solde = solde + " + transf + " where idAccount = '" + loginTo + "';");
				sql.closeSqlAll();
				return 1;			
		} catch (SQLException e) {e.printStackTrace();}
		return 0;
	}
	
	
	public String[][] getTableAccounts(){
		ArrayList<Account> user = this.getAccounts();
		String[][] res = new String[user.size()][3];
		int i = 0;
		for (Account usr : user) {
			res[i][0] = usr.getIdAccount();
			res[i][1] = NumberFormat.getCurrencyInstance(new Locale("fr", "MA")).format(usr.getSolde());
			res[i][2] = usr.getType();
			i++;
		}
		return res;
	}

	public String[] getTableAccount(String idAccount){
		String[][] res = this.getTableAccounts();
		for (String[] usr : res) {
			if (usr[0].equals(idAccount))
				return usr;
		}
		return null;
	}
	public String[] getTableAccountHeaders(){
		return new String[]{"Login", "Solde", "Type"};
	}
}
