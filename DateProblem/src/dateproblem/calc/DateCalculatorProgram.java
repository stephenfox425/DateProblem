package dateproblem.calc;

public class DateCalculatorProgram {

	public static void main(String[] args) {
		if(args.length != 6) {
			System.out.println("Usage: DateCalculatorProgram <month> <day> <year> <month> <day> <year>");
		} else {
			DateCalculator calc = new DateCalculator();
			System.out.println("Number of days between dates: " + 
					calc.getDaysBetweenDates(Integer.valueOf(args[0]), Integer.valueOf(args[1]),
					Integer.valueOf(args[2]), Integer.valueOf(args[3]),
					Integer.valueOf(args[4]), Integer.valueOf(args[5])));
		}
		
	}

}
