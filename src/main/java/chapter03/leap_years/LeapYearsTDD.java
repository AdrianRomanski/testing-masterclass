package chapter03.leap_years;

public class LeapYearsTDD {

    public boolean isLeapYear(int number) {
        if(number < 0) {
            throw new RuntimeException("Year cannot be lower than zero");
        }
        if(number == 0) {
            throw new RuntimeException("Year cannot be zero");
        }
        if(number % 400 == 0) {
            return true;
        } else if(number % 100 == 0 && number % 400 != 0) {
            return false;
        } else if(number % 4 == 0 && number % 100 != 0) {
            return true;
        } else if(number % 4 != 0) {
            return false;
        }
    return false;
    }
}
