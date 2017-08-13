package co.tw.interview.main;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.tw.interview.converter.IConverter;
import com.tw.interview.main.Exchange;
import com.tw.interview.main.ParserFactory;
import com.tw.interview.mapper.IMapper;
import com.tw.interview.parser.IParser;
import com.tw.interview.parser.MapperParser;
import com.tw.interview.parser.QueryParser;
import com.tw.interview.parser.RuleParser;

@RunWith(MockitoJUnitRunner.class)
public class ParserFactoryTest {

	
	private ParserFactory parserFactory;
	
	@Mock
	private IMapper mapper;
	
	@Mock
	private Exchange exchange;
	
	@Mock
	private IConverter converter;
	
	@Before
	public void setUp() throws Exception {
		parserFactory = new ParserFactory(mapper,exchange,converter);
	}

	@Test
	public void testGetParser_forinvalid() {
		
		String input ="hey everyOne";
		IParser parser = parserFactory.getParser(input);
		Assert.assertEquals(parser, null);
	}
	
	@Test
	public void testGetParser_mapperParser() {
		
		String input ="pish is M";
		IParser parser = parserFactory.getParser(input);
		Assert.assertTrue(parser instanceof MapperParser);
		
	}
	
	@Test
	public void testGetParser_ruleParser() {
		
		String input ="glob prok Gold is 57800 Credits";
		IParser parser = parserFactory.getParser(input);
		Assert.assertTrue(parser instanceof RuleParser);
		
	}
	
	@Test
	public void testGetParser_queryParser() {
		
		String input = "how much is pish tegj glob glob ?";
		IParser parser = parserFactory.getParser(input);
		Assert.assertTrue(parser instanceof QueryParser);
		
	}

}
