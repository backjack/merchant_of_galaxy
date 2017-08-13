package co.tw.interview.parser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.tw.interview.mapper.IMapper;
import com.tw.interview.mapper.ToRomanMapper;
import com.tw.interview.parser.MapperParser;

@RunWith(MockitoJUnitRunner.class)
public class MapperParserTest {

	MapperParser mapperParser;
	
	private IMapper mapper;
	
	@Before
	public void setUp() throws Exception {
		mapper = new ToRomanMapper();
		mapperParser = new MapperParser(mapper);
	}

	@Test
	public void testParseValid() {
		String inputString = " pish is XL";
	    mapperParser.parse(inputString);
	    Assert.assertEquals("XL", mapper.get("pish"));
	}
	
	@Test
	public void testParseInValid() {
		String inputString = " pish is is XL";
		mapperParser.parse(inputString);
		Assert.assertNotEquals("XL", mapper.get("pish"));
	}

}
