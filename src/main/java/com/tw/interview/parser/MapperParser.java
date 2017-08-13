package com.tw.interview.parser;

import com.tw.interview.mapper.IMapper;

/**
 * 
 * Mapper Class to Parser statement which has mapping between Intergallectic Numeral and Roman Numeral
 * such as "pish is X"
 * 
 * @author SONY
 *
 */
public class MapperParser extends AbstractParser{

	
	private final static String PARSER = " is ";
	private IMapper mapper;
	
	public MapperParser(IMapper mapper) {
		
		this.mapper = mapper;
	}
	
	
	
	public IMapper getMapper() {
		return mapper;
	}

	@Override
	public String processInput(String input) throws Exception {
		 String values[] = input.split(PARSER);
		 if(values!=null && values.length == 2) {
		    mapper.put(values[0].trim(), values[1].trim());
		    return null;
		 }
		 return null;
	}
}
