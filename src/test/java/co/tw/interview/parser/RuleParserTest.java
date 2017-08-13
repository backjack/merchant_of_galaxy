package co.tw.interview.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.tw.interview.converter.IConverter;
import com.tw.interview.main.Exchange;
import com.tw.interview.mapper.IMapper;
import com.tw.interview.parser.RuleParser;

@RunWith(MockitoJUnitRunner.class)
public class RuleParserTest {

	private RuleParser ruleParser;
	
	@Mock
	private IConverter converter;
	@Mock
	private IMapper mapper;
	
	@Mock
	private Exchange exchange;
	
	@Before
	public void setUp() throws Exception {
		
		ruleParser = new RuleParser(exchange,converter,mapper);
	}

	@Test
	public void testProcessInput() throws Exception {
	
		Mockito.when(converter.convert("pish pish", mapper)).thenReturn(10L);
		Mockito.when(exchange.putRateForElement("Iron", 391d)).thenReturn(null);
		String validInput = "pish pish Iron is 3910 Credits";
		ruleParser.processInput(validInput);
	}
	
	/*@Test
	public void testGetElementQty() {
		String validInput = "pish pish Iron";
		String[] elemQty = ruleParser.getElementQty(validInput);
		System.out.println(elemQty[0]);
		assertEquals(elemQty[0], "pish pish");
		assertEquals(elemQty[1], "Iron");
	}
	
	@Test
	public void testGetCreditsValid() {
		String validInput = " 57800 Credits ";
		Double value = ruleParser.getCredits(validInput);
		assertEquals(57800,value.longValue());
	}
	
	@Test
	public void testGetCreditsNull() {
		String validInput = " Credits ";
		Double value = ruleParser.getCredits(validInput);
		assertEquals(value,null);
	}
 
	@Test
	public void testGetCreditsInvalid() {
		String validInput = " xyz Credits ";
		Double value = ruleParser.getCredits(validInput);
		assertEquals(value,null);
	}*/
}
