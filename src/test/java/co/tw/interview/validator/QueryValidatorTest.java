package co.tw.interview.validator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.tw.interview.main.Exchange;
import com.tw.interview.mapper.IMapper;
import com.tw.interview.mapper.ToRomanMapper;
import com.tw.interview.validator.QueryValidator;

public class QueryValidatorTest {

	private QueryValidator queryValidator;
	private Exchange exchange;
	
	private IMapper mapper;
	
	@Before
	public void setUp() throws Exception {
		
		exchange = new Exchange();
		mapper = new ToRomanMapper();
		queryValidator = new QueryValidator(mapper,exchange);
		
		mapper.put("abc","I");
		mapper.put("xyz","V");
		mapper.put("pqr","X");
		
		
		exchange.putRateForElement("Gold", 10d);
		exchange.putRateForElement("Silver", 20d);
	}

	@Test
	public void testValidate() {
	
		String input = "how much is abc xyz abc ?";
		Assert.assertTrue(queryValidator.validate(input));
		
		input = "how many Credits is xyz abc Silver ?";
		Assert.assertTrue(queryValidator.validate(input));
	}
	
	@Test
	public void testInValidate() {
	
		String input = "how much is abc xyz abc ipqr?";
		Assert.assertTrue(!queryValidator.validate(input));
		
		input = "how many Credits is xyz abc Copper ?";
		Assert.assertTrue(!queryValidator.validate(input));
	}


}
