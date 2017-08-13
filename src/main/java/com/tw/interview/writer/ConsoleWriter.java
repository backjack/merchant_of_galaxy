package com.tw.interview.writer;


public class ConsoleWriter implements IWriter{

	@Override
	public boolean write(String output) {

		if(output!=null) {
			System.out.println(output);
		}
		return true;
	}

}
