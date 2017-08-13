package com.tw.interview.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.tw.interview.converter.IConverter;
import com.tw.interview.main.Exchange;
import com.tw.interview.mapper.IMapper;


/**
 * 
 * RuleParser to parse correlation statement between Elemnts and Credits
 * such as ""pish pish Iron is 3910 Credits"
 * @author SONY
 *
 */
public class RuleParser extends AbstractParser {

	private Exchange exchange;
	private IConverter converter;
	private IMapper mapper;
	
	public RuleParser(Exchange exchange, IConverter converter, IMapper mapper) {
		
		this.exchange = exchange;
		this.converter = converter;
		this.mapper = mapper;
	}


	@Override
	public String processInput(String input) throws Exception {
		// TODO Auto-generated method stub
		String values[] = input.split(" is ");
		String[] elemQty = getElementQty(values[0]);
		Double credits = getCredits(values[1]);
		Long quantity = converter.convert(elemQty[0], mapper);
		Double creditPerUnit = getCreditsPerUnit(credits, quantity);
		exchange.putRateForElement(elemQty[1], creditPerUnit);
		return null;
	}
	
	protected Double getCreditsPerUnit(Double credits, Long quantity) {
		
		return  credits/quantity;
	}
	
	protected String[] getElementQty(String input) {
		String element = input.substring(input.lastIndexOf(" ") + 1);
		String quantity  = input.substring(0, input.indexOf(element));
		String [] elemQty = new String[2];
		elemQty[0] = quantity.trim();
		elemQty[1] = element.trim();
		return elemQty;
	}
	

	protected Double getCredits(String input) {
		
		Pattern pattern = Pattern.compile("\\s*(\\d+)\\s*Credits\\s*");
		Matcher matcher = pattern.matcher(input);
		if(matcher.find()) {
			String credits = matcher.group(1);
			return Double.parseDouble(credits.trim());
		}
		return  null;
	}

}
