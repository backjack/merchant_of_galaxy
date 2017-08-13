package com.tw.interview.main;

import java.util.HashMap;
import java.util.Map;
/**
 * 
 * The below class maintains exchangeRate between Element and Credits
 * @author SONY
 *
 */
public class Exchange {

	private Map<String,Double> exchangeRate;
	
	public Exchange() {
		exchangeRate = new HashMap<String,Double>();
	}
	
	public Double getRateForElement(String element) {
		
		return exchangeRate.get(element);
	}
	
	public Double putRateForElement(String element, Double rate) {
		
		 return exchangeRate.put(element,rate);
	}
	
	public Double calculate(Long qty, String element) {
		
		Double rate = exchangeRate.get(element);
		return qty* rate;
	}
	
	
	
}
