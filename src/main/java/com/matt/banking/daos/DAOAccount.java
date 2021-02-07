package com.matt.banking.daos;

import java.util.ArrayList;

import com.matt.banking.pojos.POJOAccount;

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
}
