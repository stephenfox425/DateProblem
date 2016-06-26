package dateproblem.calc;

public class DateCalculator {

	private final int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public int getDaysBetweenDates(int month1, int day1, int year1, int month2, int day2, int year2) {
		int result = 0;

		if (month1 == month2 && day1 == day2 && year1 == year2) {
			return result;
		} else {
			int firstDay, firstMonth, firstYear, secondDay, secondMonth, secondYear;

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
			
			if (firstYear == secondYear) {
				if (firstMonth == secondMonth) {
					result = secondDay - firstDay - 1;
				} else {
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
				result = result + getDaysFromEndOfYear(firstMonth, firstDay, firstYear);
				result = result + getDaysFromStartOfYear(secondMonth, secondDay, secondYear);

				// get number of whole years between the dates.
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

}
