package com.ntm.transactionmanagement.exception;

public class InsufficientAmountException extends RuntimeException{
	public InsufficientAmountException(String message) {
		super(message);
	}
}
