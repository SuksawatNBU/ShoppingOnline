package com.somapait.common;

import java.io.Serializable;

import com.somapait.domain.Transaction;

public class CommonDomain implements Serializable {

	private static final long serialVersionUID = 5281141596896595011L;
	
	private Transaction transaction = new Transaction();
	private String id;

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
	
}
