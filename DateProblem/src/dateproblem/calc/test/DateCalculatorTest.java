package dateproblem.calc.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import dateproblem.calc.DateCalculator;

public class DateCalculatorTest {
	
	private DateCalculator calc;
	
	@Before
	public void setUp() {
		calc = new DateCalculator();
	}
	
	@Test
	public void testDateCalcDays() {
		assertEquals(calc.getDaysBetweenDates(6, 2, 1983, 6, 22, 1983), 19);
		assertEquals(calc.getDaysBetweenDates(12, 30, 1999, 1, 2, 2000), 2);
	}
	
	@Test
	public void testDateCalcMonths() {
		assertEquals(calc.getDaysBetweenDates(7, 4, 1984, 12, 25, 1984), 173);
	}
	
	@Test
	public void testDateCalcYears() {
		assertEquals(calc.getDaysBetweenDates(1, 3, 1989, 3, 8, 1983), 2127);
	}
	
	@Test
	public void testDateCalcSameDate() {
		assertEquals(calc.getDaysBetweenDates(1, 3, 1989, 1, 3, 1989), 0);
	}
	
	//used to test private methods. We do not want the methods exposing now, 
	//but they were exposed for testing.
//	@Test
//	public void testFromStartOfYear() {
//		assertEquals(calc.getDaysFromStartOfYear(1, 3, 1989), 2);
//		assertEquals(calc.getDaysFromStartOfYear(2, 3, 1989), 33);
//		assertEquals(calc.getDaysFromStartOfYear(9, 3, 1989), 245);
//		assertEquals(calc.getDaysFromStartOfYear(9, 3, 2000), 246);
//	}
//	
//	@Test
//	public void testFromEndOfYear() {
//		assertEquals(calc.getDaysFromEndOfYear(1, 3, 1989), 362);
//		assertEquals(calc.getDaysFromEndOfYear(9, 3, 1989), 119);
//		assertEquals(calc.getDaysFromEndOfYear(9, 3, 2000), 119);
//		assertEquals(calc.getDaysFromEndOfYear(12, 30, 1999), 1);
//	}

}
