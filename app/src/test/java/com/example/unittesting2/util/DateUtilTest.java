package com.example.unittesting2.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static com.example.unittesting2.util.DateUtil.*;
import static org.junit.jupiter.api.Assertions.*;

public class DateUtilTest {

    public static final String TODAY = "11-2019";

    @Test
    void testCurrentTimeStamp_returnedTimeStamp() {
        assertDoesNotThrow(new Executable() {
            @Override
            public void execute() throws Throwable {
                assertEquals(TODAY, getCurrentTimeStamp());
                System.out.println("Timestamp generated Correctly");
            }
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7,8,9,10,11})
    void getMonthFromNumber_returnedSuccess(int number, TestInfo testInfo, TestReporter testReporter){
        assertEquals(months[number], getMonthFromNumber(monthNumbers[number]));
        System.out.println(monthNumbers[number] + " ! " + months[number]);
    }


    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,7,8,9,10,11})
    void getMonthFromNumber_returnedError(int number, TestInfo testInfo, TestReporter testReporter){
        int randomInt = new Random().nextInt(90) + 13;
        assertEquals(getMonthFromNumber(String.valueOf(number * randomInt)), GET_MONTH_ERROR);
        System.out.println(monthNumbers[number] + " : " + GET_MONTH_ERROR);
    }
}
