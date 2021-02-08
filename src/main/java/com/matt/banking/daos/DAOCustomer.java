package com.matt.banking.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.matt.banking.pojos.POJOCustomer;
import com.matt.banking.utils.DB;

public class DAOCustomer extends POJOCustomer implements DAO{

	public DAOCustomer() {
		super();
	}

	public DAOCustomer(ArrayList<DAOAccount> accounts, ArrayList<DAOTransaction> transactions) {
		super(accounts, transactions);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create() {
		boolean success = false;
		try {
			Connection conn = DB.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from registeruser(?,?,?)");
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, "CUSTOMER");
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				userID=rs.getInt(1);
				success=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public void read() {
		try {
			Connection conn = DB.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from getusertransactions(?)");
			ps.setInt(1, userID);
			ResultSet rs = ps.executeQuery();
			accounts = new ArrayList<DAOAccount>();
			transactions = new ArrayList<DAOTransaction>();
			while(rs.next()){
				DAOTransaction transaction = new DAOTransaction();
				transaction.setTransactionID(rs.getInt("transaction_id"));
				transaction.setAmount(rs.getFloat("amount"));
				transaction.setFromAccount(rs.getInt("from_account"));
				transaction.setToAccount(rs.getInt("to_account"));
				transaction.setFromUser(rs.getInt("from_user"));
				transaction.setToUser(rs.getInt("to_user"));
				transaction.setTimestamp(rs.getDate("timestamp"));
				transaction.setPending(rs.getBoolean("accepted"));
				transactions.add(transaction);
			}
			ps.close();			
			ps = conn.prepareStatement("select * from getalluseraccounts(?)");
			ps.setInt(1, userID);
			rs = ps.executeQuery();
			while(rs.next()){
				DAOAccount account = new DAOAccount();
				account.setAccountID(rs.getInt("account_id"));
				account.setBalance(rs.getFloat("balance"));
				account.setType(rs.getString("account_type"));
				accounts.add(account);
			}
			ps.close();
			ps = conn.prepareStatement("select * from users where user_id=?");
			ps.setInt(1, userID);
			rs = ps.executeQuery();
			if(rs.next())
				username=rs.getString("username");
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean update() {
		boolean success=false;
		try {
			Connection conn = DB.getConnection();
			CallableStatement cs = conn.prepareCall("call acceptuser(?,?)");
			cs.setInt(1, userID);
			cs.setBoolean(2, approved);
			cs.executeUpdate();
			success=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public ArrayList<DAOAccount> getAccounts(){
		for(DAOAccount account:accounts) {
			account.read();
		}
		return accounts;
	}

	public static ArrayList<DAOCustomer> getPending() {
		ArrayList<DAOCustomer> customers = new ArrayList<DAOCustomer>();
		try {
			Connection conn = DB.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from getallpendingusers()");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				DAOCustomer customer = new DAOCustomer();
				customer.setUserID(rs.getInt("user_id"));
				customer.setUsername(rs.getString("username"));
				customers.add(customer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customers;
	}

}
