package co.tw.interview.converter;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tw.interview.validator.RomanValidator;

public class RomanValidatorTest {

	private RomanValidator romanValidator;
	
	@Before
	public void setUp() throws Exception {
		romanValidator = new RomanValidator();
	}

	@Test
	public void testValidate() {

		
		String [] valids = {"MCMLXXXIV","MMMCMXCVIII"}; 
		for(String valid:valids) {
		  Assert.assertTrue(romanValidator.validate(valid));
		}
		
		String[] invalids = {"XLVVX","IIII","XM","IC","",null};
		for(String invalid:invalids) {
			Assert.assertFalse(romanValidator.validate(invalid));
		}
	}

}
