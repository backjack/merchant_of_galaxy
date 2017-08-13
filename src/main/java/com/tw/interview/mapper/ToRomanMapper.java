package com.tw.interview.mapper;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Below class to map intergalectic Numeral with Roman Numeral
 * @author SONY
 *
 */
public class ToRomanMapper implements IMapper{

	private Map<String,String> galaticToRomanMapper;
	
	public ToRomanMapper() {
		
		galaticToRomanMapper = new HashMap<String,String>();
	}
	
	@Override
	public void put(String galaticalSymbol, String numeral) {
		// TODO Auto-generated method stub
		galaticToRomanMapper.put(galaticalSymbol, numeral);
	}

	@Override
	public String get(String galaticalSymbol) {
		// TODO Auto-generated method stub
		return galaticToRomanMapper.get(galaticalSymbol);
	}

}
