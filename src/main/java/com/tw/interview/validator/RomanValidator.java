package com.tw.interview.validator;


/**
 * 
 * Below class to validate if input String is Roman Number
 * @author SONY
 *
 */
public class RomanValidator extends InputValidator {
	
	public boolean validate(String input) {
		
		if(super.validate(input)) {
			
			return input.matches("^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");
		}
		return false;
	}

}
