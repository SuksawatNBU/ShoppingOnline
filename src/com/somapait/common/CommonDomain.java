package com.somapait.common;

import java.io.Serializable;

import com.somapait.domain.Active;
import com.somapait.domain.Transaction;

public class CommonDomain implements Serializable {

	private static final long serialVersionUID = 5281141596896595011L;
	
	private String id;
	private Active active = new Active(); // สถานะ ของ data นั้นๆ
	private Transaction transaction = new Transaction();

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

	public Active getActive() {
		return active;
	}

	public void setActive(Active active) {
		this.active = active;
	}
	
	
}
