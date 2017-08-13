package com.tw.interview.converter;

import com.tw.interview.mapper.IMapper;
/***
 * 
 * Below interface needs to be implemented by the classes which converts given Type to Number
 * 
 * 
 * @author SONY
 *
 */
public interface IConverter {

	Long convert(String input, IMapper mapper) throws Exception;
	
	Long convert(String[] input, IMapper mapper)throws Exception;
}
