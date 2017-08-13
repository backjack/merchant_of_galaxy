----------------------
Read Me - Merchant of Galaxy
----------------------
#################
Project Exceution
#################

MarketCalculator is main class of the Project. It takes input as filePath as an argument and outputs on console.

- Build App using maven then execute below command
  *java -jar interview-0.0.1-SNAPSHOT.jar [filepath]

- You can also execute it from MarketCalculatorTest, by calling testProcessFileReader() function
  
  
########################
Project Description
########################  

- Project mainly consist of following core components
  1) Reader - its an input component to the app. It can be extended to FileReader or ConsoleReader.
  2) Writer - Its an output component to the app. It can be extended to FileWriter or ConsoleWriter.
  3) Parser - It parses the input received from the file. There can be 3 type of parses
                - MapperParser: It parses input received from file and maps intergaletic units to Numeral.
				- RuleParser: It parses input received from the file and calculates rate of an element
				- QueryParser: It parses input received from the file and outputs the query.
  4) Validator - It validates input String received from file. In project we have two types of Validator
				- RomanValidator : It validates input and checks if its valid Roman Numeral
				- QueryValidator : It validates input query received from the file.
  
             
  5) Converter - Its converts intergaltic units to Human Known numeral
                 - RomanConverter: It mainly converts intergaltic units to RomanNumerals then to Decimal system.
  
  6) Exchange  - Its stores the price of Elemnet per Credit. Eg: 1 Silver 4 Credits etc.
  
  7) MarketCalculator - Its main class of Project
  8) ParseFactory - Its identify parser on basis of input received.
  
  You can also refer class diagram for relation between the classes.
 
####################
Assumptions
####################

- Parsing of input line is case senstive (except Roman numerals)
- Query will always start with string "how much is" or "how many Credits is"
- Input line which provides map between intergalatic units and Roman Numeral will of pattern "(\w)+(\s)+is(\s)+(\w)+"
- if any Qurty input doesn't satisfies the condition then output will be "I have no idea what you are talking about"
- The output of Credits is printed with value, after removing floating values. Ex 125.4 will be printed as 125
-----------------------------------------------------------------------------------------------------------------------------

