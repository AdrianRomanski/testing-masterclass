package chapter02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyClassTest {

    @Test
    void shouldSumUpTwoNumbers() {

        int first = 2;
        int second = 3;

        int result = first + second;

        assertEquals(5, result);
    }

    @Test
    @DisplayName("")
    void testingTestingTest() {
        //given

        //when

        //then
    }
}
