package com.matt.banking.daos;

import com.matt.banking.pojos.POJOEmployee;

public class DAOEmployee extends POJOEmployee implements DAO{

	public DAOEmployee() {
		super();
	}

	public DAOEmployee(int userID, String username, String password) {
		super(userID, username, password);
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
