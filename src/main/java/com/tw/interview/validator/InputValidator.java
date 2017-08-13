package com.tw.interview.validator;

public class InputValidator implements Validator{

	public boolean validate(String input) {
		
		if(input== null || "".equals(input)) {
			 return false;
		}
		return true;
	}
}
