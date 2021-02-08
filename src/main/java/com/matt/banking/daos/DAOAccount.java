package com.matt.banking.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.matt.banking.pojos.POJOAccount;
import com.matt.banking.utils.DB;

public class DAOAccount extends POJOAccount implements DAO{

	public DAOAccount() {
		super();
	}
	
	public DAOAccount(int accountID, float balance, String type, ArrayList<Integer> ownerIDs, ArrayList<DAOTransaction> history) {
		super(accountID, balance, type, ownerIDs,  history);
	}
	@Override
	public boolean create() {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean update() {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	public static ArrayList<DAOAccount> getPending() {
		ArrayList<DAOAccount> accounts = new ArrayList<DAOAccount>();
		try {
			Connection conn = DB.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from getallpendingaccounts()");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				DAOAccount account = new DAOAccount();
				account.setAccountID(rs.getInt("account_id"));
				account.setBalance(rs.getFloat("balance"));
				account.setType(rs.getString("account_type"));
				ArrayList<Integer> owners = new ArrayList<Integer>();
				owners.add(rs.getInt("user_id"));
				account.setOwnerIDs(owners);
				accounts.add(account);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accounts;
	}
}
