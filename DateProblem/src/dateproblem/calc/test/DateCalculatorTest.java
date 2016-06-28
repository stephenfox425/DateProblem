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
		assertEquals(calc.getDaysBetweenDates(2, 29, 2000, 1, 30, 2000), 26);
	}
	
	@Test
	public void testDateCalcMonths() {
		assertEquals(calc.getDaysBetweenDates(7, 4, 1984, 12, 25, 1984), 173);
		assertEquals(calc.getDaysBetweenDates(7, 4, 2000, 10, 19, 2000), 106);
		assertEquals(calc.getDaysBetweenDates(7, 4, 1984, 9, 25, 1984), 82);
		assertEquals(calc.getDaysBetweenDates(2, 29, 2996, 12, 25, 2996), 301);
	}
	
	@Test
	public void testDateCalcYears() {
		assertEquals(calc.getDaysBetweenDates(1, 3, 1989, 3, 8, 1983), 2127);
		assertEquals(calc.getDaysBetweenDates(1, 1, 1901, 12, 31, 2999), 401407);
		assertEquals(calc.getDaysBetweenDates(1, 3, 1901, 1, 3, 2001), 36524);
		assertEquals(calc.getDaysBetweenDates(1, 1, 2000, 12, 31, 2999), 365247);
		assertEquals(calc.getDaysBetweenDates(1, 3, 2150, 3, 8, 1983), 60932);
	}
	
	@Test
	public void testDateCalcSameDate() {
		assertEquals(calc.getDaysBetweenDates(1, 3, 1989, 1, 3, 1989), 0);
		assertEquals(calc.getDaysBetweenDates(2, 29, 2000, 2, 29, 2000), 0);
	}
	
	@Test
	public void testValidDataInputs() {
		assertEquals(calc.verifyInputs(1, 3, 1989, 1, 3, 1989), true);
		assertEquals(calc.verifyInputs(1, 1, 1901, 12, 31, 2999), true);
		assertEquals(calc.verifyInputs(2, 29, 1988, 2, 29, 2000), true);
	}
	
	@Test
	public void testNotValidDataInputs() {
		assertEquals(calc.verifyInputs(-1, 3, 1989, 1, 3, 1989), false);
		assertEquals(calc.verifyInputs(1, 3, 1900, 1, 3, 1989), false);
		assertEquals(calc.verifyInputs(1, 3, 1989, 1, 3, 3000), false);
		assertEquals(calc.verifyInputs(0, 0, 0, 0, 0, 0), false);
		assertEquals(calc.verifyInputs(2, 29, 1989, 1, 3, 1989), false);
		assertEquals(calc.verifyInputs(1, -3, 1989, 1, 3, 1989), false);
		assertEquals(calc.verifyInputs(1, 3, -1989, 1, 3, 1989), false);
		assertEquals(calc.verifyInputs(1, 3, 1989, -1, 3, 1989), false);
		assertEquals(calc.verifyInputs(1, 3, 1989, 1, -3, 1989), false);
		assertEquals(calc.verifyInputs(1, 3, 1989, 1, 3, -1989), false);
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
