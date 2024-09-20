package ca.bcit.creature.yujin.jeong;

/**
 * This class models date formats.
 * Firstly, checks the validation of year, month, day if they are correct in the range, including checks leap year.
 * Secondly, finds a day of week with calculation using year,month,day ( Calculation formula is explained in the method
 * getDayOfTheWeek() between the every step)
 * Lastly, printing the date in two different formats ("YYYY-MM-DD" and "Month(in String) DD, YYYY").
 *
 * @author Gem Baojimin sha
 * @author Yujin Jeong
 * @version 1.0
 */

public class Date
{

    // Creating static variables to set a range of year.
    private static final int STARTING_YEAR = 1;
    private static final int CURRENT_YEAR  = 2024;

    // Creating static variables to calculate leap year
    private static final int NO_REMAINDER                       = 0;
    private static final int LEAP_YEAR_DIVISIBLE_BY_FOURHUNDRED = 400;
    private static final int LEAP_YEAR_DIVISIBLE_BY_FOUR        = 4;
    private static final int LEAP_YEAR_DIVISIBLE_BY_HUNDRED     = 100;

    // Creating static variables to set a range days of month.
    private static final int FIRST_MONTH     = 1;
    private static final int SHORT_FEB_MONTH = 28;
    private static final int LONG_FEB_MONTH  = 29;
    private static final int SHORT_MONTH     = 30;
    private static final int LONG_MONTH      = 31;

    // Creating static variables to set months.
    private static final int JAN  = 1;
    private static final int FEB  = 2;
    private static final int MAR  = 3;
    private static final int APR  = 4;
    private static final int MAY  = 5;
    private static final int JUN  = 6;
    private static final int JULY = 7;
    private static final int AUG  = 8;
    private static final int SEP  = 9;
    private static final int OCT  = 10;
    private static final int NOV  = 11;
    private static final int DEC  = 12;

    // Creating static variables to assign starting and ending year of 1800s and 2000s.
    private static final int STARTING_YEAR_OF_1800S = 1800;
    final                int ENDING_YEAR_OF_1800S   = 1899;
    final                int STARTING_YEAR_OF_2000S = 2000;

    // Creating variables to get day, month, year, and current date.
    final int day;
    final int month;
    final int year;

    /**
     * Creating a constructor.
     *
     * @param year  will be assigned to the instance data: year
     * @param month will be assigned to the instance data: month
     * @param day   will be assigned to the instance data: day
     */
    public Date(final int year, final int month, final int day)
    {
        isYearValid(year);
        isMonthValid(month);
        isDayValid(year, month, day);

        this.year  = year;
        this.month = month;
        this.day   = day;
    }

    /**
     * Creating getter to get year.
     *
     * @return year
     */
    public int getYear()
    {
        return year;
    }

    /**
     * Creating getter to get month.
     *
     * @return month
     */
    public int getMonth()
    {
        return month;

    }

    /**
     * Creating getter to get day.
     *
     * @return day
     */
    public int getDay()
    {
        return day;

    }

    /**
     * Creating method to print date in the format "YYYY-MM-DD".
     *
     * @return formatted date
     */
    public String getYYYYMMDD()
    {
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    /**
     * Creating helper method to match the months(in integer) to corresponding name of month(in String).
     *
     * @return months of the week in String (e.g. 1 for "January")
     */
    public String getMonthInString(final int month) throws IllegalArgumentException
    {
        final String stringOfMonth;

        // Creating switch to return the month in Strings
        switch(month)
        {
            case JAN:
                stringOfMonth = "January";
                break;
            case FEB:
                stringOfMonth = "February";
                break;
            case MAR:
                stringOfMonth = "March";
                break;
            case APR:
                stringOfMonth = "April";
                break;
            case MAY:
                stringOfMonth = "May";
                break;
            case JUN:
                stringOfMonth = "June";
                break;
            case JULY:
                stringOfMonth = "July";
                break;
            case AUG:
                stringOfMonth = "August";
                break;
            case SEP:
                stringOfMonth = "September";
                break;
            case OCT:
                stringOfMonth = "October";
                break;
            case NOV:
                stringOfMonth = "November";
                break;
            case DEC:
                stringOfMonth = "December";
                break;
            default:
                throw new IllegalArgumentException("Invalid Month: " + month);
        }
        return stringOfMonth;
    }

    /**
     * Creating method to print date in the format "Month(In string) DD, YYYY".
     *
     * @return formated date
     */
    public String getDateInString()
    {

        return String.format("%s %02d, %04d", getMonthInString(month), day, year);
    }

    /*
     * Creating a method if the year is valid.
     * @param year check if the year is valid
     * @throws IllegalArgumentException if the month is out of range and empty
     */
    private static void isYearValid(final int year) throws IllegalArgumentException
    {
        if(STARTING_YEAR > year || CURRENT_YEAR < year)
        {
            throw new IllegalArgumentException("You must enter the correct year");
        }
    }

    /*
     * Creating a method if the year is leap year.
     * @param year check if the year is leap year
     * @return false if the year is not leap year
     */
    private static boolean isLeapYear(final int year)
    {

        return (year % LEAP_YEAR_DIVISIBLE_BY_FOURHUNDRED == NO_REMAINDER || (year % LEAP_YEAR_DIVISIBLE_BY_FOUR == NO_REMAINDER && year % LEAP_YEAR_DIVISIBLE_BY_HUNDRED != NO_REMAINDER));
    }

    /*
     * Creating a method if the month is valid.
     * @param month check if the month is valid
     * @throws IllegalArgumentException if the month is null or blank
     */
    private static void isMonthValid(final int month) throws IllegalArgumentException
    {

        if(JAN > month || DEC < month)
        {
            throw new IllegalArgumentException("You must enter the month between " + JAN + "  to 12");
        }
    }

    /*
     * Creating a method if the day is valid.
     * @param day check if the day is valid
     * @throws IllegalArgumentException if the day is out of range
     */
    private static void isDayValid(final int year, final int month, final int day) throws IllegalArgumentException
    {
        final int maxDaysOfMonth;

        maxDaysOfMonth = numbOfDaysInMonth(month, year);

        if(FIRST_MONTH > day || maxDaysOfMonth < day)
        {
            throw new IllegalArgumentException("You must enter the correct day");
        }
    }

    /*
     * Creating method to classify the number of days in a given month of a given year.
     * @param month take month and classify the number of days in a given month
     * @param year take different number of days in February and check if it's leap year
     * @return the number of days
     */
    private static int numbOfDaysInMonth(final int month, final int year) throws IllegalArgumentException
    {

        switch(month)
        {
            case JAN:
            case MAR:
            case MAY:
            case JULY:
            case AUG:
            case OCT:
            case DEC:
                return LONG_MONTH;
            case APR:
            case JUN:
            case SEP:
            case NOV:
                return SHORT_MONTH;
            case FEB:
                return isLeapYear(year) ? LONG_FEB_MONTH : SHORT_FEB_MONTH;
            default:
                throw new IllegalArgumentException(String.format("Invalid days of %d", month));
        }
    }

    /**
     * Creating a method that finds a day of the week (e.g. 2024.Sep.08 is Sunday).
     * <p>
     * Formula to get day of the week:
     * Step0: add 6(for Jan/Feb dates in leap years or for all dates in the 2000s),or add 2(for all dates in the 1800s)
     * Step1: Get last two digits of year.
     * Step2: Get the number of twelves in last two digits of year.
     * Step3: Get the remainder from stepTwo(the numbers of twelves in last two digits of year).
     * Step4: Get the number of fours from stepThree.
     * Step5: Add the result of stepZero, stepOne, stepTwo, stepThree and stepFour.
     * Step6: Add month code to stepFive.
     * (Month code: JAN = 1/FAB= 4/MAR = 4/APR = 0/MAY = 2/JUN = 5/JULY = 0/AUG = 3/SEP = 6/OCT = 1/NOV = 4/DEC = 6)
     * Step7: Get a remainder of 7 from stepSix
     * Step8: Match the remainder from Step7 to days of week code.
     * (Days code: SAT = 0/SUN = 1/MON = 2/TUE = 3/WED = 4/THUR = 5/FRI = 6)
     *
     * @return days of week in String
     *
     * @throws IllegalArgumentException if invalid month is founded in month code
     */
    public String getDayOfTheWeek() throws IllegalArgumentException
    {

        // Creating local variables to add value in Step 0.
        final int startZeroStep0 = 0;
        final int addTwoStep0    = 2;
        final int addSixStep0    = 6;

        // Creating local variable to find remainder of step1 by 100
        final int remainderHundredStep1 = 100;

        // Creating local variable to divide step1 by 12
        final int divideTwelveStep2 = 12;

        // Creating local variable to find remainder of Step3 by 12
        final int remainderTwelveStep3 = 12;

        // Creating local variable to divide step4 by 4
        final int divideFourStep4 = 4;

        // Creating local variables to add values depending on the month code
        // (Month code: JAN = 1/FAB= 4/MAR = 4/APR = 0/MAY = 2/JUN = 5/JULY = 0/AUG = 3/SEP = 6/OCT = 1/NOV = 4/DEC = 6)
        final int addZeroStep6  = 0;
        final int addOneStep6   = 1;
        final int addTwoStep6   = 2;
        final int addThreeStep6 = 3;
        final int addFourStep6  = 4;
        final int addFiveStep6  = 5;
        final int addSixStep6   = 6;

        // Creating local variable to find remainder of step7 by 7
        final int remainderSevenStep7 = 7;

        // Creating local variables to switch remainder of step 7 to the given day in String depending on the day code.
        // (Days code: SAT = 0/SUN = 1/MON = 2/TUE = 3/WED = 4/THUR = 5/FRI = 6)
        final int dayCodeSat  = 0;
        final int dayCodeSun  = 1;
        final int dayCodeMon  = 2;
        final int dayCodeTues = 3;
        final int dayCodeWed  = 4;
        final int dayCodeThur = 5;
        final int dayCodeFri  = 6;

        final String dayOfWeek;

        // Step0: add 6(for Jan/Feb dates in leap years or for all dates in the 2000s),
        // or add 2(for all dates in the 1800s)
        int stepZero = startZeroStep0;

        if(isLeapYear(year) && (month == JAN || month == FEB))
        {
            stepZero += addSixStep0;
            if(STARTING_YEAR_OF_1800S <= year && ENDING_YEAR_OF_1800S > year)
            {
                stepZero += addTwoStep0;
            }
            else if(STARTING_YEAR_OF_2000S <= year && CURRENT_YEAR >= year)
            {
                stepZero += addSixStep0;
            }
        }
        else
        {
            if(STARTING_YEAR_OF_1800S <= year && ENDING_YEAR_OF_1800S > year)
            {
                stepZero += addTwoStep0;
            }
            else if(STARTING_YEAR_OF_2000S <= year && CURRENT_YEAR >= year)
            {
                stepZero += addSixStep0;
            }
        }
        // Step1: Getting last two digits of year.
        int stepOne = year % remainderHundredStep1;

        // Step2: Getting the number of twelves in last two digits of year.
        int stepTwo = stepOne / divideTwelveStep2;

        // Step3: Getting the remainder from stepTwo(the numbers of twelves in last two digits of year).
        int stepThree = stepOne % remainderTwelveStep3;

        // Step4: Getting the number of fours from stepThree.
        int stepFour = stepThree / divideFourStep4;

        // Step5: Adding the result of stepZero, stepOne, stepTwo, stepThree and stepFour.
        int stepFive;
        stepFive = day + stepTwo + stepThree + stepFour + stepZero;

        // Step6: Adding month code to stepFive.
        int stepSix;
        switch(month)
        {
            case APR:
            case JULY:
                stepSix = stepFive + addZeroStep6;
                break;
            case JAN:
            case OCT:
                stepSix = stepFive + addOneStep6;
                break;
            case MAY:
                stepSix = stepFive + addTwoStep6;
                break;
            case AUG:
                stepSix = stepFive + addThreeStep6;
                break;
            case FEB:
            case MAR:
            case NOV:
                stepSix = stepFive + addFourStep6;
                break;
            case JUN:
                stepSix = stepFive + addFiveStep6;
                break;
            case SEP:
            case DEC:
                stepSix = stepFive + addSixStep6;
                break;
            default:
                throw new IllegalArgumentException(String.format("Invalid %d!", month));
        }

        // Step7: Getting a remainder of 7 from stepSix
        int stepSeven = stepSix % remainderSevenStep7;
        // Creating a switch to return the days of the week (as Strings), aligned with their corresponding day codes.
        switch(stepSeven)
        {
            case dayCodeSat:
                dayOfWeek = "Saturday";
                break;
            case dayCodeSun:
                dayOfWeek = "Sunday";
                break;
            case dayCodeMon:
                dayOfWeek = "Monday";
                break;
            case dayCodeTues:
                dayOfWeek = "Tuesday";
                break;
            case dayCodeWed:
                dayOfWeek = "Wednesday";
                break;
            case dayCodeThur:
                dayOfWeek = "Thursday";
                break;
            case dayCodeFri:
                dayOfWeek = "Friday";
                break;
            default:
                throw new IllegalArgumentException(String.format("Invalid: %d", day));

        }

        return dayOfWeek;
    }

    /**
     * Creating a method to compare birthdate and current date, making sure birthdate doesn't go more than current date
     * Firstly, check if the date of birth year is the same as current year. If not the same, subtracting follow code
     * Secondly, check if the date of birth month is the same as current month. If not the same, subtracting follow code
     * Thirdly, in case check the both days too
     * Lastly, if return value is negative than date of birth is before the current date. If it's 0 then both dates are
     * the same, and positive value will return date of birth is after the current date, which is wrong.
     *
     * @param currentDate
     *
     * @return
     */
    public int compareTo(final Date currentDate)
    {
        if(this.year != currentDate.year)
        {
            return this.year - currentDate.year;
        }
        if(this.month != currentDate.month)
        {
            return this.month - currentDate.month;
        }
        return this.day - currentDate.day;
    }

}