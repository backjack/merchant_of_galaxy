package com.tw.interview.converter;

import com.tw.interview.mapper.IMapper;
import com.tw.interview.validator.RomanValidator;
import com.tw.interview.validator.Validator;

public class RomanConverter implements IConverter {

	private Validator inputValidator;
	
	public RomanConverter() {
		inputValidator = new RomanValidator();
	}
	
	public RomanConverter(Validator inputValidator) {
		this.inputValidator = inputValidator;
	}
	
	public Validator getInputValidator() {
		return inputValidator;
	}

	public void setInputValidator(Validator inputValidator) {
		this.inputValidator = inputValidator;
	}

	@Override
	public Long convert(String input, IMapper mapper) throws Exception{
		
		String chars[] = input.split(" ");
		try {
				return convert(chars,mapper);
		}catch(Exception ex) {
			
			throw new Exception(ex.getMessage() + ": "+input);
		}
	}

	@Override
	public Long convert(String[] input, IMapper mapper) throws Exception {
		
		StringBuilder romanNumeralBuildr = new StringBuilder();
		for(String charVal:input) {
			String romanNumber = mapper.get(charVal);
			romanNumeralBuildr.append(romanNumber);
		}
		String romanNumber = romanNumeralBuildr.toString();
		validate(romanNumber);
		return romanToDecimal(romanNumber);
	}
	
	private void validate(String input) throws Exception {
		if(!inputValidator.validate(input)) {
			throw new Exception("Not a valid Roman Number");
		}
	}
	
	public static long romanToDecimal(String romanNumber) {
		
        long decimal = 0;
        long lastNumber = 0;
        String romanNumeral = romanNumber.toUpperCase();

        for (int x = romanNumeral.length() - 1; x >= 0 ; x--) {
            char convertToDecimal = romanNumeral.charAt(x);

            switch (convertToDecimal) {
                case 'M':
                    decimal = processDecimal(1000, lastNumber, decimal);
                    lastNumber = 1000;
                    break;

                case 'D':
                    decimal = processDecimal(500, lastNumber, decimal);
                    lastNumber = 500;
                    break;

                case 'C':
                    decimal = processDecimal(100, lastNumber, decimal);
                    lastNumber = 100;
                    break;

                case 'L':
                    decimal = processDecimal(50, lastNumber, decimal);
                    lastNumber = 50;
                    break;

                case 'X':
                    decimal = processDecimal(10, lastNumber, decimal);
                    lastNumber = 10;
                    break;

                case 'V':
                    decimal = processDecimal(5, lastNumber, decimal);
                    lastNumber = 5;
                    break;

                case 'I':
                    decimal = processDecimal(1, lastNumber, decimal);
                    lastNumber = 1;
                    break;
            }
        }
        return decimal;
    }

	 private static long processDecimal(long decimal, long lastNumber, long lastDecimal) {
	        if (lastNumber > decimal) {
	            return lastDecimal - decimal;
	        } else {
	            return lastDecimal + decimal;
	        }
	    }
	 
	 public static void main(String args[]) {
		 
		 String strs[] ={"I","II","III","IV","V","VI","VII","VIII","IX","X","XI","XII","XIII","XIV","XV","XVI","XVII","XVIII","XIX","XX","XXI","XXII","XXIII","XXIV","XXV","XXVI","XXVII","XXVIII","XXIX","XXX","XXXI","XXXII","XXXIII","XXXIV","XXXV","XXXVI","XXXVII","XXXVIII","XXXIX","XL","XLI","XLII","XLIII","XLIV","XLV","XLVI","XLVII","XLVIII","XLIX","L","LI","LII","LIII","LIV","LV","LVI","LVII","LVIII","LIX","LX","LXI","LXII","LXIII","LXIV","LXV","LXVI","LXVII","LXVIII","LXIX","LXX","LXXI","LXXII","LXXIII","LXXIV","LXXV","LXXVI","LXXVII","LXXVIII","LXXIX","LXXX","LXXXI","LXXXII","LXXXIII","LXXXIV","LXXXV","LXXXVI","LXXXVII","LXXXVIII","LXXXIX","XC","XCI","XCII","XCIII","XCIV","XCV","XCVI","XCVII","XCVIII","XCIX","C","CI","CII","CIII","CIV","CV","CVI","CVII","CVIII","CIX","CX","CXI","CXII","CXIII","CXIV","CXV","CXVI","CXVII","CXVIII","CXIX","CXX","CXXI","CXXII","CXXIII","CXXIV","CXXV","CXXVI","CXXVII","CXXVIII","CXXIX","CXXX","CXXXI","CXXXII","CXXXIII","CXXXIV","CXXXV","CXXXVI","CXXXVII","CXXXVIII","CXXXIX","CXL","CXLI","CXLII","CXLIII","CXLIV","CXLV","CXLVI","CXLVII","CXLVIII","CXLIX","CL","CLI","CLII","CLIII","CLIV","CLV","CLVI","CLVII","CLVIII","CLIX","CLX","CLXI","CLXII","CLXIII","CLXIV","CLXV","CLXVI","CLXVII","CLXVIII","CLXIX","CLXX","CLXXI","CLXXII","CLXXIII","CLXXIV","CLXXV","CLXXVI","CLXXVII","CLXXVIII","CLXXIX","CLXXX","CLXXXI","CLXXXII","CLXXXIII","CLXXXIV","CLXXXV","CLXXXVI","CLXXXVII","CLXXXVIII","CLXXXIX","CXC","CXCI","CXCII","CXCIII","CXCIV","CXCV","CXCVI","CXCVII","CXCVIII","CXCIX","CC","CCI","CCII","CCIII","CCIV","CCV","CCVI","CCVII","CCVIII","CCIX","CCX","CCXI","CCXII","CCXIII","CCXIV","CCXV","CCXVI","CCXVII","CCXVIII","CCXIX","CCXX","CCXXI","CCXXII","CCXXIII","CCXXIV","CCXXV","CCXXVI","CCXXVII","CCXXVIII","CCXXIX","CCXXX","CCXXXI","CCXXXII","CCXXXIII","CCXXXIV","CCXXXV","CCXXXVI","CCXXXVII","CCXXXVIII","CCXXXIX","CCXL","CCXLI","CCXLII","CCXLIII","CCXLIV","CCXLV","CCXLVI","CCXLVII","CCXLVIII","CCXLIX","CCL","CCLI","CCLII","CCLIII","CCLIV","CCLV","CCLVI","CCLVII","CCLVIII","CCLIX","CCLX","CCLXI","CCLXII","CCLXIII","CCLXIV","CCLXV","CCLXVI","CCLXVII","CCLXVIII","CCLXIX","CCLXX","CCLXXI","CCLXXII","CCLXXIII","CCLXXIV","CCLXXV","CCLXXVI","CCLXXVII","CCLXXVIII","CCLXXIX","CCLXXX","CCLXXXI","CCLXXXII","CCLXXXIII","CCLXXXIV","CCLXXXV","CCLXXXVI","CCLXXXVII","CCLXXXVIII","CCLXXXIX","CCXC","CCXCI","CCXCII","CCXCIII","CCXCIV","CCXCV","CCXCVI","CCXCVII","CCXCVIII","CCXCIX","CCC","CCCI","CCCII","CCCIII","CCCIV","CCCV","CCCVI","CCCVII","CCCVIII","CCCIX","CCCX","CCCXI","CCCXII","CCCXIII","CCCXIV","CCCXV","CCCXVI","CCCXVII","CCCXVIII","CCCXIX","CCCXX","CCCXXI","CCCXXII","CCCXXIII","CCCXXIV","CCCXXV","CCCXXVI","CCCXXVII","CCCXXVIII","CCCXXIX","CCCXXX","CCCXXXI","CCCXXXII","CCCXXXIII","CCCXXXIV","CCCXXXV","CCCXXXVI","CCCXXXVII","CCCXXXVIII","CCCXXXIX","CCCXL","CCCXLI","CCCXLII","CCCXLIII","CCCXLIV","CCCXLV","CCCXLVI","CCCXLVII","CCCXLVIII","CCCXLIX","CCCL","CCCLI","CCCLII","CCCLIII","CCCLIV","CCCLV","CCCLVI","CCCLVII","CCCLVIII","CCCLIX","CCCLX","CCCLXI","CCCLXII","CCCLXIII","CCCLXIV","CCCLXV","CCCLXVI","CCCLXVII","CCCLXVIII","CCCLXIX","CCCLXX","CCCLXXI","CCCLXXII","CCCLXXIII","CCCLXXIV","CCCLXXV","CCCLXXVI","CCCLXXVII","CCCLXXVIII","CCCLXXIX","CCCLXXX","CCCLXXXI","CCCLXXXII","CCCLXXXIII","CCCLXXXIV","CCCLXXXV","CCCLXXXVI","CCCLXXXVII","CCCLXXXVIII","CCCLXXXIX","CCCXC","CCCXCI","CCCXCII","CCCXCIII","CCCXCIV","CCCXCV","CCCXCVI","CCCXCVII","CCCXCVIII","CCCXCIX","CD","CDI","CDII","CDIII","CDIV","CDV","CDVI","CDVII","CDVIII","CDIX","CDX","CDXI","CDXII","CDXIII","CDXIV","CDXV","CDXVI","CDXVII","CDXVIII","CDXIX","CDXX","CDXXI","CDXXII","CDXXIII","CDXXIV","CDXXV","CDXXVI","CDXXVII","CDXXVIII","CDXXIX","CDXXX","CDXXXI","CDXXXII","CDXXXIII","CDXXXIV","CDXXXV","CDXXXVI","CDXXXVII","CDXXXVIII","CDXXXIX","CDXL","CDXLI","CDXLII","CDXLIII","CDXLIV","CDXLV","CDXLVI","CDXLVII","CDXLVIII","CDXLIX","CDL","CDLI","CDLII","CDLIII","CDLIV","CDLV","CDLVI","CDLVII","CDLVIII","CDLIX","CDLX","CDLXI","CDLXII","CDLXIII","CDLXIV","CDLXV","CDLXVI","CDLXVII","CDLXVIII","CDLXIX","CDLXX","CDLXXI","CDLXXII","CDLXXIII","CDLXXIV","CDLXXV","CDLXXVI","CDLXXVII","CDLXXVIII","CDLXXIX","CDLXXX","CDLXXXI","CDLXXXII","CDLXXXIII","CDLXXXIV","CDLXXXV","CDLXXXVI","CDLXXXVII","CDLXXXVIII","CDLXXXIX","CDXC","CDXCI","CDXCII","CDXCIII","CDXCIV","CDXCV","CDXCVI","CDXCVII","CDXCVIII","CDXCIX"};
		 for(String str:strs) {
		  System.out.println(romanToDecimal(str));
		 }
		 
	 }
}
