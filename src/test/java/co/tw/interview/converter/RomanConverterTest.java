package co.tw.interview.converter;



import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tw.interview.converter.RomanConverter;
import com.tw.interview.mapper.IMapper;
import com.tw.interview.mapper.ToRomanMapper;

public class RomanConverterTest {

	private RomanConverter romanConverter;
	
	private IMapper mapper;
	
	@Before
	public void setUp() throws Exception {
		
		romanConverter = new RomanConverter();
		mapper = new ToRomanMapper();
		mapper.put("abc", "I");
		mapper.put("pqr", "V");
		mapper.put("xyz", "X");
		mapper.put("zxc", "L");
	}

	@Test
	public void testConvertStringIMapper_invalid() {
		
		String input ="pqr pqr pqr";
		try {
			long output = romanConverter.convert(input, mapper);
			fail("Not a valid Roman Number");
		 } catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	@Test
	public void testConvertStringIMapper_valid() {
		
		String input ="xyz abc pqr ";
		try {
			long output = romanConverter.convert(input, mapper);
			Assert.assertEquals(14, output);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void testRomanToDecimal_valid() {
	
		long value = romanConverter.romanToDecimal("CCLXXXVIII");
		Assert.assertEquals(288, value);
		
		value = romanConverter.romanToDecimal("IV");
		Assert.assertEquals(4, value);
		
		value = romanConverter.romanToDecimal("CDXLVIII");
		Assert.assertEquals(448, value);
		
		value = romanConverter.romanToDecimal(" CMXCVII ");
		Assert.assertEquals(997, value);
	}

}
