package co.tw.interview.main;

import org.junit.Before;
import org.junit.Test;

import com.tw.interview.main.MarketCalculator;
import com.tw.interview.reader.IReader;
import com.tw.interview.reader.MarketFileReader;
import com.tw.interview.writer.ConsoleWriter;
import com.tw.interview.writer.IWriter;

public class MarketCalculatorTest {

	MarketCalculator marketCalculator;
	
	@Before
	public void setUp() throws Exception {
		
		IReader reader = new IReader(){

			@Override
			public String[] processInput() {
			
				String [] inputs ={"glob is I","prok is V","pish is X","tegj is L","glob glob Silver is 34 Credits","glob prok Gold is 57800 Credits","pish pish Iron is 3910 Credits","how much is pish tegj glob glob ?","how many Credits is glob prok Silver ?","how many Credits is glob prok Gold ?","how many Credits is glob prok Iron ?"};
				return inputs;
			}};
		IWriter writer = new ConsoleWriter();
		marketCalculator = new MarketCalculator(reader,writer);
		
	}

	@Test
	public void testProcessInput() {
		
		try {
			marketCalculator.processInput();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testProcessFileReader() {
		
		try {
			MarketFileReader marketFileReader = new MarketFileReader("C:\\Users\\SONY\\Desktop\\Trytw\\src\\test\\resources\\input.txt");
			marketCalculator.setReader(marketFileReader);
			marketCalculator.processInput();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
