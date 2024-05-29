package com.atm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlUtils {
	private Connection myConn;
	private Statement myStmt;
	private ResultSet myRs;
	
	
	public ResultSet getResult() {
		return myRs;
	}
	public void setResult(ResultSet res) {
		myRs = res;
	}
	
	public	Statement connectedSql() throws SQLException {
		Connection myConn = null;
		Statement myStmt = null;
		try {myConn = DriverManager.getConnection("jdbc:mysql://localhost/javatm", "root", "DearGod123.");} 
		catch (SQLException e) {e.printStackTrace(); System.out.println("Connection Problem");}
		myStmt = myConn.createStatement();
		return myStmt;
	}
	
	public	void closeSqlAll() throws SQLException {
		try { if(myRs != null) myRs.close(); } catch(Exception ex) { ex.printStackTrace(); }
		try { if(myConn != null) myConn.close(); } catch(Exception ex) { ex.printStackTrace(); }
		try { if(myStmt != null) myStmt.close(); } catch(Exception ex) { ex.printStackTrace(); }
	}
	public	void closeSql() throws SQLException {
		try { if(myConn != null) myConn.close(); } catch(Exception ex) { ex.printStackTrace(); }
		try { if(myStmt != null) myStmt.close(); } catch(Exception ex) { ex.printStackTrace(); }
	}
	
}
