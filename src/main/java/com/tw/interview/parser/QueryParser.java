package com.tw.interview.parser;

import java.text.DecimalFormat;

import com.tw.interview.converter.IConverter;
import com.tw.interview.main.Exchange;
import com.tw.interview.mapper.IMapper;
import com.tw.interview.validator.InputValidator;
import com.tw.interview.validator.Validator;

/**
 * QueryParser to parse query raised by User. It parses below statement
 * "how much is pish tegj glob glob ?"
 * "how many Credits is glob prok Silver ?"
 * 
 * @author SONY
 *
 */
public class QueryParser extends AbstractParser{
	
	
	public QueryParser(InputValidator validator) {
		super(validator);
	}

	public QueryParser() {
		
	}
	public IConverter getConverter() {
		return converter;
	}

	public void setConverter(IConverter converter) {
		this.converter = converter;
	}


	public IMapper getMapper() {
		return mapper;
	}


	public void setMapper(IMapper mapper) {
		this.mapper = mapper;
	}


	public Exchange getExchange() {
		return exchange;
	}


	public void setExchange(Exchange exchange) {
		this.exchange = exchange;
	}

	private IConverter converter;
	private IMapper mapper;
	private Exchange exchange;
	
	@Override
	public String processInput(String input) throws Exception {
	
		return processQuery(input);
	}
	
	protected String processQuery(String input) throws Exception {
		
		String output =null;
		if(input!=null && !"".equals(input)) {
			if(input.startsWith("how many Credits is")) {
				output = getCreditForElements(input);
				
			} else if(input.startsWith("how much is")) {
				 output = getConvertedNumeralUnits(input);

			} 
		}
		return output;
	}
	
	private String formatOutput(Double value) {
		
		DecimalFormat df = new DecimalFormat("#");
		return df.format(value);
	}
	
	protected String getCreditForElements(String  input) throws Exception{
		
		String splits[] = input.split("how many Credits is ");
		splits[1] = splits[1].replace('?', ' ').trim();
		String element = splits[1].substring(splits[1].lastIndexOf(" ") + 1);
		splits[1] = splits[1].substring(0, splits[1].indexOf(element)).trim();	
	    long qty = converter.convert(splits[1], mapper);
		Double output = exchange.calculate(qty, element);
		return  splits[1] +" "+element+" is "+ formatOutput(output)+" Credits";
	}
	
	protected String getConvertedNumeralUnits(String input) throws Exception {
		
		String splits[] = input.split("how much is ");
		input = splits[1].replace('?', ' ').trim();
		long value = converter.convert(input, mapper);
		return  input +" is "+ value;
	}

	@Override
	public void setValidator(Validator inputValidator) {
		super.setValidator(inputValidator);
	}

}
