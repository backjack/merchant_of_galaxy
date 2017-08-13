package com.tw.interview.main;

import com.tw.interview.converter.IConverter;
import com.tw.interview.converter.RomanConverter;
import com.tw.interview.mapper.IMapper;
import com.tw.interview.mapper.ToRomanMapper;
import com.tw.interview.parser.IParser;
import com.tw.interview.reader.IReader;
import com.tw.interview.reader.MarketFileReader;
import com.tw.interview.utils.Constants;
import com.tw.interview.writer.ConsoleWriter;
import com.tw.interview.writer.IWriter;

public class MarketCalculator {

	private ParserFactory parserFactory;
	private IMapper mapper;
	private Exchange exchange;
	private IConverter converter;
	private IReader reader;
	private IWriter writer;
	
	public MarketCalculator(IReader ireader, IWriter writer) {
		
		mapper = new ToRomanMapper();
		converter = new RomanConverter();
		exchange = new Exchange(); 
		parserFactory = new ParserFactory(mapper,exchange,converter);
		this.reader = ireader;
		this.writer = writer;
		
	}
	
	public void processInput() throws Exception {
		
		String inputs[] = reader.processInput();
		for(String input:inputs) {
			processInput(input);
		}
	}
	
	private void processInput(String input) throws Exception {
		
		String output = "Invalid Input :"+input;
		IParser p = parserFactory.getParser(input);
		if(p!=null) {
		   output = p.parse(input);
		}
		writer.write(output);
	}
	
	public static void main(String[] args) throws Exception {
	
	
		if(args.length==0) {
			System.out.println("Please provide file path");
			System.exit(1);
		}
		String filePath = args[0];
		MarketFileReader fileMarketReader = new MarketFileReader(filePath);
		IWriter writer = new ConsoleWriter();
		MarketCalculator marketCalculator = new MarketCalculator(fileMarketReader,writer);
		marketCalculator.processInput();
		
	}
	
	public ParserFactory getParserFactory() {
		return parserFactory;
	}

	public void setParserFactory(ParserFactory parserFactory) {
		this.parserFactory = parserFactory;
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

	public IConverter getConverter() {
		return converter;
	}

	public void setConverter(IConverter converter) {
		this.converter = converter;
	}

	public IReader getReader() {
		return reader;
	}

	public void setReader(IReader reader) {
		this.reader = reader;
	}

	public IWriter getWriter() {
		return writer;
	}

	public void setWriter(IWriter writer) {
		this.writer = writer;
	}


}
