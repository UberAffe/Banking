package com.matt.banking.pojos;

import java.util.ArrayList;

import com.matt.banking.daos.DAOTransaction;

public class POJOAccount {
	protected int accountID;
	protected float balance;
	protected String type;
	protected boolean accepted;
	protected ArrayList<Integer> ownerIDs;
	protected ArrayList<DAOTransaction> history;
	public POJOAccount() {
		super();
		this.accountID = 0;
		this.balance = 0;
		this.type = "";
		this.ownerIDs = new ArrayList<Integer>();
		this.history = new ArrayList<DAOTransaction>();
		this.accepted = false;
	}
	public final boolean isAccepted() {
		return accepted;
	}
	public final void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}
	public final String getType() {
		return type;
	}
	public final void setType(String type) {
		this.type = type;
	}
	public final void setBalance(float balance) {
		this.balance = balance;
	}
	public POJOAccount(int accountID, float balance, String type, ArrayList<Integer> ownerIDs, ArrayList<DAOTransaction> history, boolean accepted) {
		super();
		this.accountID = accountID;
		this.balance = balance;
		this.type = type;
		this.ownerIDs = ownerIDs;
		this.history = history;
		this.accepted = accepted;
	}
	public int getAccountID() {
		return accountID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	public ArrayList<Integer> getOwnerIDs() {
		return ownerIDs;
	}
	public final float getBalance() {
		return balance;
	}
	public void setOwnerIDs(ArrayList<Integer> ownerIDs) {
		this.ownerIDs = ownerIDs;
	}
	public ArrayList<DAOTransaction> getHistory() {
		return history;
	}
	public void setHistory(ArrayList<DAOTransaction> history) {
		this.history = history;
	}
}
