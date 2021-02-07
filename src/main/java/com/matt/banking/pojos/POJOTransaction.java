package com.matt.banking.pojos;

import java.sql.Date;

public class POJOTransaction {
	protected int transactionID;
	protected int fromUser;
	protected int toUser;
	protected int fromAccount;
	protected int toAccount;
	protected float amount;
	protected boolean accepted;
	protected Date timestamp;
	public POJOTransaction() {
		super();
		this.transactionID = 0;
		this.fromUser = 0;
		this.toUser = 0;
		this.fromAccount = 0;
		this.toAccount = 0;
		this.amount = 0;
		this.accepted= true;
		this.timestamp= null;
	}
	public POJOTransaction(int transactionID, int fromUser, int toUser, int fromAccount, int toAccount, float amount, boolean pending, Date timestamp) {
		super();
		this.transactionID = transactionID;
		this.fromUser = fromUser;
		this.toUser = toUser;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.amount = amount;
		this.accepted = pending;
		this.timestamp = timestamp;
	}
	public int getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}
	public int getFromUser() {
		return fromUser;
	}
	public void setFromUser(int fromUser) {
		this.fromUser = fromUser;
	}
	public int getToUser() {
		return toUser;
	}
	public void setToUser(int toUser) {
		this.toUser = toUser;
	}
	public int getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(int fromAccount) {
		this.fromAccount = fromAccount;
	}
	public int getToAccount() {
		return toAccount;
	}
	public void setToAccount(int toAccount) {
		this.toAccount = toAccount;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public boolean isPending() {
		return accepted;
	}
	public void setPending(boolean pending) {
		this.accepted = pending;
	}
	public final Date getTimestamp() {
		return timestamp;
	}
	public final void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
}
