package chapter03.leap_years;

import org.assertj.core.api.Assertions;
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
    @DisplayName("Testing condition - All years divisible by 400 ARE leap years")
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
    @DisplayName("Testing condition - All years divisible by 100 but no by 400 are NOT leap years")
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
    @DisplayName("Testing condition - All years divisible by 100 but no by 400 ARE leap years")
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
    @DisplayName("Testing condition - All years NOT divisible by 4 ARE NOT leap years")
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
    @DisplayName("Testing condition - Input lower than zero should throw an exception")
    void shouldThrowExceptionYearLowerThanZero() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> leapYearsTDD.isLeapYear(-1))
                .withMessage("Year cannot be lower than zero");
    }


    @Test
    @DisplayName("Testing condition - Input is zero should throw an exception")
    void shouldThrowExceptionYearIsZero() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> leapYearsTDD.isLeapYear(0))
                .withMessage("Year cannot be zero");
    }
}