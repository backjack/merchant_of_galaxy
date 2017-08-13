package com.tw.interview.converter;

import java.util.Map;
import java.util.TreeMap;

public class IntegerConverter {

	
	static Map<Integer,String> romanMap = new TreeMap<Integer,String>();
	
	static{
		  romanMap.put(1, "I");
		  romanMap.put(4, "IV");
		  romanMap.put(5, "V");
		  romanMap.put(9, "IX");
		  romanMap.put(10, "X");
		  romanMap.put(40, "XL");
		  romanMap.put(50, "L");
		  romanMap.put(90, "XC");
		  romanMap.put(100, "C");
		  romanMap.put(400, "CD");
		  romanMap.put(500, "D");
		  romanMap.put(900, "DM");
		  romanMap.put(1000, "M");
	}
	
	private static String toRoman(int val){
		
		Integer previousKey = null; 
		if(val>0) {
		for(Integer key: romanMap.keySet()) {
			
			  if(val>key) {
				  previousKey = key;
			  } else if( val ==key) {
				  return romanMap.get(key);
			  } else if(val<key) {
				  int q = val/previousKey;
				  int rem = val% previousKey;
				  String valstr = "";
				  for(int i=0;i<q;i++) {
					  valstr = valstr +romanMap.get(previousKey);
				  }
				  return valstr + toRoman(rem%previousKey) ;
			  }
		   } 
		}
		
		return "";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=1;
		while(i<500) {
		 System.out.println(IntegerConverter.toRoman(i));
		 i++;
		}
	}

}
