package com.tw.interview.mapper;

public interface IMapper {

	void put(String galaticalSymbol, String numeral);
	
	String get(String galaticalSymbol);
}
