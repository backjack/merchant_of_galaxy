package com.tw.interview.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
/**
 * 
 * Below class to read input from File
 * 
 * @author SONY
 *
 */
public class MarketFileReader implements IReader{

	private BufferedReader bufferedReader;
	
	public MarketFileReader(String path) {
		
		File f = new File(path);
		try {
			FileReader fr = new FileReader(f);
			 bufferedReader = new BufferedReader(fr);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public String[] processInput() {
		
		List<String> inputList = new LinkedList<String>();
		String input = null;
		try {
			while((input=bufferedReader.readLine())!=null) {
				
				inputList.add(input);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] inputArr = inputList.toArray(new String[inputList.size()]);
		return inputArr;
	}

}
