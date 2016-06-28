# DateProblem
Calculating the number of days between 2 dates from 1901 to 2999 without using Java date functionality.

This program takes inputs in the form of 6 integers, representing <month> <day> <year> <month> <day> <year>
e.g. 1 1 1901 12 31 2999
would represent 01/01/1901 and 12/31/2999, and it returns the number of days between these two dates (exclusive).

To run this program, download the runnable jar "DateCalculator.jar" and run it from the command line using the following command:

java -jar DateCalculator.jar <month> <day> <year> <month> <day> <year>

e.g. 
java -jar DateCalculator.jar 1 1 2000 1 1 1901 
would return the following:
Number of days between dates: 36158

The input parameters must be valid dates between 01/01/1901 and 12/31/2999 or an error message will be displayed.

Calculation is done in the dateproblem.calc.DateCalculator class.
The main method and input parsing is done in the DateCalculatorProgram class.
Unit tests are stored in the DateCalculatorTest class.

The number of days if calculated in the following way:
- check if the dates are the same, if so, return 0.
- determine which date comes first chronolically.
- check if only days are different, if so get the number of days difference.
- if months are different calculate the number of days in the whole months and add the number of days in each partial month.
- if the years are different, get the number of days in each partial year, then add the number of days in each whole year.
The result is returned to the command line.
