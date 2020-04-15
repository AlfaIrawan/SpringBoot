package edu.havrelearning.springboot;


import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.UnexpectedInputException;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;



public class Reader implements ItemReader<String> {
	
	private String[] courses = {"Java Web Service","End to End Project", "Angular"};
	private int count;
	
	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		
		System.out.println("Inside Read Method");
		
		if (count < courses.length) {
			return courses[count++];
		} else {
			count = 0;
		}
		
		return null;
		
	}

}
