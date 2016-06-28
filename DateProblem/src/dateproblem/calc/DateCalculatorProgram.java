package dateproblem.calc;

public class DateCalculatorProgram {

	public static void main(String[] args) {
		if(args.length != 6) {
			System.out.println("Usage: DateCalculatorProgram <month> <day> <year> <month> <day> <year>");
		} else {
			try{
				int mon1 = Integer.valueOf(args[0]);
				int day1 = Integer.valueOf(args[1]);
				int year1 = Integer.valueOf(args[2]);
				int mon2 = Integer.valueOf(args[3]);
				int day2 = Integer.valueOf(args[4]);
				int year2 = Integer.valueOf(args[5]);
				DateCalculator calc = new DateCalculator();
				if(calc.verifyInputs(mon1, day1, year1, mon2, day2, year2)) {
					System.out.println("Number of days between dates: " + 
						calc.getDaysBetweenDates(mon1, day1, year1, mon2, day2, year2));
				} else {
					System.out.println("Please enter 2 valid dates between 01/01/1901 and 12/31/2999.");
				}
			} catch(NumberFormatException ne) {
				System.out.println("Please enter only numbers for the data parameters.");
			}
		}
		
	}

}
