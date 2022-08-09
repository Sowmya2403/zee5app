package com.zee.zee5app.exceptions;

import com.mysql.cj.exceptions.UnableToConnectException;

public class UNableToGenerateIdException extends Exception {
	public UNableToGenerateIdException(String msg) {
		super(msg);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}

}
