package com.matt.banking.pojos;

import java.util.ArrayList;

import com.matt.banking.daos.DAOAccount;
import com.matt.banking.daos.DAOTransaction;

public class POJOCustomer extends POJOUser{
	@Override
	public String toString() {
		return "POJOCustomer [accounts=" + accounts + ", transactions=" + transactions + ", userID=" + userID
				+ ", username=" + username + ", password=" + password + "]";
	}
	protected ArrayList<DAOAccount> accounts;
	protected ArrayList<DAOTransaction> transactions;
	public POJOCustomer() {
		super();
		this.userID = 0;
		this.username = "";
		this.password = "";
		this.accounts = new ArrayList<DAOAccount>();
		this.transactions = new ArrayList<DAOTransaction>();
	}
	public POJOCustomer(ArrayList<DAOAccount> accounts, ArrayList<DAOTransaction> transactions) {
		super();
		this.accounts = accounts;
		this.transactions = transactions;
	}
	public ArrayList<DAOAccount> getAccounts() {
		return accounts;
	}
	public void setAccounts(ArrayList<DAOAccount> accounts) {
		this.accounts = accounts;
	}
	public final ArrayList<DAOTransaction> getTransactions() {
		return transactions;
	}
	public final void setTransactions(ArrayList<DAOTransaction> transactions) {
		this.transactions = transactions;
	}
}
