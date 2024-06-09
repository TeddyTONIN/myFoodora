package myFoodora.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import myFoodora.model.Date;

public class DateTest {

	@Test
	public void testDate() {
		Date date1= new Date(9,6,2024);
		Date date2= new Date(6,5,2024);
		
		assertTrue(date2.isBefore(date1));
		assertFalse(date1.isBefore(date2));
	}
	
	@Test
	public void testequals() {
		Date date1= new Date(9,6,2024);
		Date date2= new Date(6,5,2024);
		Date date3= new Date(9,6,2024);
		assertFalse(date2.equals(date1));
		assertTrue(date3.equals(date1));
	}

}
