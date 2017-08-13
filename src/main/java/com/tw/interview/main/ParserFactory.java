package com.tw.interview.main;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import com.tw.interview.converter.IConverter;
import com.tw.interview.mapper.IMapper;
import com.tw.interview.parser.IParser;
import com.tw.interview.parser.MapperParser;
import com.tw.interview.parser.QueryParser;
import com.tw.interview.parser.RuleParser;
import com.tw.interview.validator.InputValidator;
import com.tw.interview.validator.QueryValidator;

import static com.tw.interview.utils.Constants.MAPPER_PARSER;
import static com.tw.interview.utils.Constants.QUERY_PARSER;
import static com.tw.interview.utils.Constants.RULE_PARSER;

/**
 * 
 * ParserFactory fetches appropriate Parser parser for every input to Parse.
 * 
 * @author SONY
 *
 */
public class ParserFactory {

	private IMapper mapper;
	private Exchange exchange;
	private IConverter converter;
	private Map<String,IParser> parserMap;
	
	public ParserFactory(IMapper mapper, Exchange xchnage, IConverter converter) {
		
		this.mapper = mapper;
		this.exchange = xchnage;
		this.converter = converter;
		parserMap = new HashMap<String,IParser>();
		buildParserMap();
	}
	
	private void buildParserMap() {
		
		IParser parser = new MapperParser(mapper);
		parserMap.put(MAPPER_PARSER, parser);
		parser = new RuleParser(exchange,converter,mapper);
		parserMap.put(RULE_PARSER, parser);
		InputValidator validator = new QueryValidator(mapper,exchange);
		QueryParser queryParser =  new QueryParser();
		queryParser.setConverter(converter);
		queryParser.setExchange(exchange);
		queryParser.setMapper(mapper);
		queryParser.setValidator(validator);
		parserMap.put(QUERY_PARSER, queryParser);
	}
	
	public IParser getParser(String input) {
	
		if(input!=null && !"".equals(input)) {
			
			String words[] = input.split(" ");
			boolean matches = Pattern.matches(".*\\s*(\\d+)\\s*Credits\\s*", input);
			if(words.length == 3) {
				return parserMap.get(MAPPER_PARSER);
			} else if(matches) {
				return parserMap.get(RULE_PARSER);
			} else if(input.startsWith("how many Credits is") || input.startsWith("how much is")) {
				return parserMap.get(QUERY_PARSER);
				
			} else {
				return null;
			}
		}
		
		return null;
	}
}
