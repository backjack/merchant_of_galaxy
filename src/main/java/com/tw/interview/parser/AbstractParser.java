package com.tw.interview.parser;

import com.tw.interview.utils.Constants;
import com.tw.interview.validator.InputValidator;
import com.tw.interview.validator.Validator;

/**
 * 
 * Abstract Parser class to parse the statement
 * 
 * @author SONY
 *
 */
public abstract class AbstractParser implements IParser{

	private Validator validator;
	
	public Validator getValidator() {
		return validator;
	}

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	public AbstractParser() {
		validator = new InputValidator();
	}
	
	public AbstractParser(Validator validator) {
		this.validator = validator;
	}
	
	public String parse(String input) {
	
		boolean isValid = validator.validate(input); 
		if(!isValid) {
			return Constants.DEFAULT_ANSWER;
		}
		try {
			return processInput(input);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}
	
	public abstract String processInput(String input) throws Exception;
	
}
