package org.java.milestone;

import java.math.BigDecimal;
import java.text.ParseException;
import java.time.LocalTime;

import org.java.event.Concerto;

public class Milestone3 {
	
	public static void main(String[] args) throws IllegalArgumentException, ParseException {
		
		Concerto con = new Concerto("max20", "23/10/2024", 30000, LocalTime.parse("23:00"), BigDecimal.valueOf(30.50));
		
		System.out.println(con);
	}
}
