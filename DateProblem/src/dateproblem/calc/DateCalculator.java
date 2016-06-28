package dateproblem.calc;

public class DateCalculator {

	private final int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public int getDaysBetweenDates(int month1, int day1, int year1, int month2, int day2, int year2) {
		int result = 0;
		
		//check if dates are equal
		if (month1 == month2 && day1 == day2 && year1 == year2) {
			return result;
		} else {
			int firstDay, firstMonth, firstYear, secondDay, secondMonth, secondYear;
			//determine which of the dates comes first or second chronologially
			if ((year1 < year2) || 
					(year1 == year2 && month1 < month2) || 
					(year1 == year2 && month1 == month2 && day1 <= day2)) {
				firstDay = day1;
				firstMonth = month1;
				firstYear = year1;
				secondDay = day2;
				secondMonth = month2;
				secondYear = year2;
			} else {
				firstDay = day2;
				firstMonth = month2;
				firstYear = year2;
				secondDay = day1;
				secondMonth = month1;
				secondYear = year1;
			}
			//first determine if the years are the same.
			if (firstYear == secondYear) {
				//determine if the months are the same.
				if (firstMonth == secondMonth) {
					//the dates are in the same month and year, find the number of days between each.
					result = secondDay - firstDay - 1;
				} else {
					//the dates are in different months, determine how many days there are between
					//the first day and the end of the month it is in, 
					//and from the start of the month containing the second day to its day. 
					result = result + (daysInMonth[firstMonth] - firstDay - 1);
					if (firstMonth == 2 && firstDay < 29 && firstYear % 4 == 0) {
						result = result + 1;
					}
					result = result + secondDay;
					// add days in whole months
					for (int index1 = firstMonth; index1 < secondMonth - 1; index1++) {
						result = result + daysInMonth[index1];
						// factor in leap year
						if (index1 == 1 && firstYear % 4 == 0) {
							result++;
						}
					}
				}
			} else {
				//dates are in different years, get the number of days to count in both the first and second partial year.
				result = result + getDaysFromEndOfYear(firstMonth, firstDay, firstYear);
				result = result + getDaysFromStartOfYear(secondMonth, secondDay, secondYear);

				// get number of whole years between the dates, and the days they contain.
				int yearsDifference = secondYear - firstYear - 1;
				result = result + (yearsDifference * 365);
				int currentYear = firstYear + 1;
				while (currentYear < secondYear) {
					if (currentYear % 4 == 0) {
						result++;
					}
					currentYear++;
				}
			}

			return result;
		}
	}

	//method to get the number of days from the start of the year to the day listed.
	private int getDaysFromStartOfYear(int month, int day, int year) {
		int days = 0;
		
		// add days in whole months
		if (month > 1) {
			for (int currentMonth = 0; currentMonth < (month - 1); currentMonth++) {
				days = days + daysInMonth[currentMonth];
				// check for february in a leap year
				if (currentMonth == 1 && year % 4 == 0) {
					days = days + 1;
				}
			}
		}
		days = days + (day - 1);

		return days;
	}

	//method to get the number of days from the day listed to the end fo the year.
	private int getDaysFromEndOfYear(int month, int day, int year) {
		int days = 0;
		
		// add days in whole months
		if (month < 12) {
			for (int currentMonth = month; currentMonth < 12; currentMonth++) {
				days = days + daysInMonth[currentMonth];
				// check for february in a leap year
				if (currentMonth == 1 && year % 4 == 0) {
					days = days++;
				}
			}
		}
		int daysThisMonth = daysInMonth[month - 1] - day;
		days = days + (daysThisMonth);

		return days;
	}
	
	//Method to check that the inputs constitute 2 valid dates between 01/01/1901 and 12/31/2999.
	public boolean verifyInputs(int mon1, int day1, int year1, int mon2, int day2, int year2) {
		boolean validInputs = false;
		
		//check if all the inputs are positive
		if(mon1 > 0 && day1 > 0 && year1 > 0 && mon2 > 0 && day2 > 0 && year2 > 0) {
			//check the months are valid
			if(mon1 < 13 && mon2 < 13) {
				//check the days are valid for their months including a check for leap years.
				if((day1 <= daysInMonth[mon1-1] || (day1 == 29 && mon1 == 2 && (year1%4) == 0)) 
						&& (day2 <= daysInMonth[mon2-1] || (day2 == 29 && mon2 == 2 && (year2%4) == 0))) {
					//check the years are valid
					if(year1 > 1900 && year1 < 3000 && year2 > 1900 && year2 < 3000) {
						validInputs = true;
					}
				} 
			}
		}
		
		return validInputs;
	}

}
