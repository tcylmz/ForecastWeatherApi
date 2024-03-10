package com.weather.forecast.util;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class DateUtilTests {

    @Test
    void isDayLaterFromCurrentDay_WithDateBeforeCurrentDate_ReturnsFalse() {
        // Current date - 1 day
        LocalDateTime pastDate = LocalDateTime.now().minusDays(1);

        // Assert that pastDate is not later than the current date by 1 day
        assertFalse(DateUtil.isDayLaterFromCurrentDay(pastDate, 1));
    }

    @Test
    void isDayLaterFromCurrentDay_WithSameDateAsCurrentDate_ReturnsFalse() {
        // Current date
        LocalDateTime currentDate = LocalDateTime.now();

        // Assert that currentDate is not later than the current date by 0 days
        assertFalse(DateUtil.isDayLaterFromCurrentDay(currentDate, 0));
    }

    @Test
    void getAsDate_WithValidDateString_ReturnsLocalDateTime() {
        // Given a valid date string
        String dateString = "2024-03-10 12:30:45";

        // When parsing the date string
        LocalDateTime result = DateUtil.getAsDate(dateString);

        // Then the result should not be null
        assertNotNull(result);
        // Optionally, you can assert specific values if you know the expected outcome
        assertEquals(2024, result.getYear());
        assertEquals(3, result.getMonthValue());
        assertEquals(10, result.getDayOfMonth());
        assertEquals(12, result.getHour());
        assertEquals(30, result.getMinute());
        assertEquals(45, result.getSecond());
    }

    @Test
    void getAsDate_WithInvalidDateString_ReturnsNull() {
        // Given an invalid date string
        String invalidDateString = "2024-03-10T12:30:45"; // Incorrect format

        // When parsing the invalid date string
        LocalDateTime result = DateUtil.getAsDate(invalidDateString);

        // Then the result should be null
        assertNull(result);
    }
}
