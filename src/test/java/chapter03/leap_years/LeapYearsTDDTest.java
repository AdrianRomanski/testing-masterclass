package chapter03.leap_years;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class LeapYearsTDDTest {

    LeapYearsTDD leapYearsTDD;

    @BeforeEach
    void setUp() {
        leapYearsTDD = new LeapYearsTDD();
    }


    @Test
    @DisplayName("Should Return True if Year is Divisible by 400")
    void shouldReturnTrueDivisibleBy400() {
        int first = 2000;
        int second = 400;
        int third = 800;
        int fourth = 4000;

        boolean resultFirst = leapYearsTDD.isLeapYear(first);
        boolean resultSecond = leapYearsTDD.isLeapYear(second);
        boolean resultThird = leapYearsTDD.isLeapYear(third);
        boolean resultFourth = leapYearsTDD.isLeapYear(fourth);

        assertThat(resultFirst).isTrue();
        assertThat(resultSecond).isTrue();
        assertThat(resultThird).isTrue();
        assertThat(resultFourth).isTrue();
    }


    @Test
    @DisplayName("Should Return False if Year is Divisible by 100 but not by 400")
    void shouldReturnFalseDivisibleBy100ButNotBy400() {
        int first = 1700;
        int second = 1800;
        int third = 1900;
        int fourth = 2100;

        boolean resultFirst = leapYearsTDD.isLeapYear(first);
        boolean resultSecond = leapYearsTDD.isLeapYear(second);
        boolean resultThird = leapYearsTDD.isLeapYear(third);
        boolean resultFourth = leapYearsTDD.isLeapYear(fourth);

        assertThat(resultFirst).isFalse();
        assertThat(resultSecond).isFalse();
        assertThat(resultThird).isFalse();
        assertThat(resultFourth).isFalse();
    }


    @Test
    @DisplayName("Should Return True if Year is Divisible by 4 but not by 100")
    void shouldReturnTrueDivisibleBy4ButNoBy100() {
        int first = 4;
        int second = 80;
        int third = 220;
        int fourth = 340;

        boolean resultFirst = leapYearsTDD.isLeapYear(first);
        boolean resultSecond = leapYearsTDD.isLeapYear(second);
        boolean resultThird = leapYearsTDD.isLeapYear(third);
        boolean resultFourth = leapYearsTDD.isLeapYear(fourth);

        assertThat(resultFirst).isTrue();
        assertThat(resultSecond).isTrue();
        assertThat(resultThird).isTrue();
        assertThat(resultFourth).isTrue();
    }


    @Test
    @DisplayName("Should Return False if Year is not Divisible by 4")
    void shouldReturnFalseNotDivisibleBy4() {
        int first = 2017;
        int second = 2018;
        int third = 2019;
        int fourth = 2021;

        boolean resultFirst = leapYearsTDD.isLeapYear(first);
        boolean resultSecond = leapYearsTDD.isLeapYear(second);
        boolean resultThird = leapYearsTDD.isLeapYear(third);
        boolean resultFourth = leapYearsTDD.isLeapYear(fourth);

        assertThat(resultFirst).isFalse();
        assertThat(resultSecond).isFalse();
        assertThat(resultThird).isFalse();
        assertThat(resultFourth).isFalse();
    }


    @Test
    @DisplayName("Should Throw an Exception if Input is Lower Than Zero")
    void shouldThrowExceptionYearLowerThanZero() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> leapYearsTDD.isLeapYear(-1))
                .withMessage("Year cannot be lower than zero");
    }


    @Test
    @DisplayName("Should Throw an Exception if Input is Equal to Zero")
    void shouldThrowExceptionYearIsZero() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> leapYearsTDD.isLeapYear(0))
                .withMessage("Year cannot be zero");
    }
}