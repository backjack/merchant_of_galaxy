package com.tw.interview.validator;

import com.tw.interview.main.Exchange;
import com.tw.interview.mapper.IMapper;

/**
 * 
 * QueryValidator class is used by QueryParser to validate input.
 * 
 * @author SONY
 *
 */
public class QueryValidator extends InputValidator{

	private IMapper mapper;
	
	private Exchange exchange;
	
	public QueryValidator(IMapper mapper, Exchange exchange) {
		this.mapper = mapper;
		this.exchange = exchange;
	}
	
	public boolean validate(String input) {
		if(super.validate(input)) {
			input = input.replace('?',' ').trim();
			if(input.startsWith("how much is ")) {
				return validateNumericalQuery(input);
			}
			else {
				return validateCreditsQuery(input);
			}
		}
		return false;
	}
	
	private boolean validateNumericalQuery(String input) {
		String tempValues[] = input.split("how much is ");
		String galecticValues [] = tempValues[1] != null? tempValues[1].split(" "): null;
		
		
		if(galecticValues==null) {
			return false;
		}
		
		for(String galectic:galecticValues) {
			
			if(mapper.get(galectic.trim())==null) {
				return false;
			}
		}
		return true;
	}
	
	private boolean validateCreditsQuery(String input) {
		String tempValues[] = input.split("how many Credits is");
		String galecticValues [] = tempValues[1] != null? tempValues[1].trim().split(" "):null;
		boolean completeCheckingGalecticValues = false;
		
		for(String galectic:galecticValues) {
			
			if(!completeCheckingGalecticValues && mapper.get(galectic.trim())==null) {
				completeCheckingGalecticValues =true;

			}
			
			if(completeCheckingGalecticValues && exchange.getRateForElement(galectic)==null){
				 return false;
			}
			
		}
		return true;
	}
}
