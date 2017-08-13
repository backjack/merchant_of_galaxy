package co.tw.interview.parser;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.tw.interview.converter.IConverter;
import com.tw.interview.main.Exchange;
import com.tw.interview.mapper.IMapper;
import com.tw.interview.parser.QueryParser;

@RunWith(MockitoJUnitRunner.class)
public class QueryParserTest {

	private QueryParser queryParser;
	@Mock
	private IConverter converter;
	@Mock
	private IMapper mapper;
	
	@Mock
	private Exchange xchnage;
	
	@Before
	public void setUp() throws Exception {
	
		queryParser = new QueryParser();
		queryParser.setConverter(converter);
		queryParser.setMapper(mapper);
		queryParser.setExchange(xchnage);
	}

	@Test
	public void testCheckForQuery() throws Exception {

		Mockito.when(converter.convert("glob prok", mapper)).thenReturn(20L);
		Mockito.when(xchnage.calculate(20l ,"Silver")).thenReturn(400d);
		String input = "how many Credits is glob prok Silver ?";
		String value = queryParser.processInput(input);
		Assert.assertEquals("glob prok Silver is 400 Credits", value);
		
	
	}

	@Test
	public void testCheckForQuery_NumericalQty() throws Exception {
		
		Mockito.when(converter.convert("pish tegj glob glob", mapper)).thenReturn(200L);
		String input = "how much is pish tegj glob glob ?";
		String value = queryParser.processInput(input);
		Assert.assertEquals("pish tegj glob glob is 200", value);
	}

}
