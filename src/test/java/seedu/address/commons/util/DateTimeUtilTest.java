package seedu.address.commons.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.Assert.assertThrows;

import java.time.DateTimeException;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class DateTimeUtilTest {

    @Test
    public void parseDate_invalidDate_throwsDateTimeParseException() {
        // null
        String invalidApplicationDate0 = null;
        // empty string
        String invalidApplicationDate1 = "";
        // random letters
        String invalidApplicationDate2 = "asdfqawe";
        // No numbers
        String invalidApplicationDate3 = "/ / ";
        // Invalid date-like string
        String invalidApplicationDate4 = "12/13/2020";
        // Bad date format
        String invalidApplicationDate5 = "12^12^2020";
        // Extra stuff
        String invalidApplicationDate6 = "12/12/2020 haha";
        // Too much numbers
        String invalidApplicationDate7 = "12/12/12/2020";
        assertThrows(NullPointerException.class, () -> DateTimeUtil.parseDate(invalidApplicationDate0));
        assertThrows(DateTimeException.class, () -> DateTimeUtil.parseDate(invalidApplicationDate1));
        assertThrows(DateTimeException.class, () -> DateTimeUtil.parseDate(invalidApplicationDate2));
        assertThrows(DateTimeException.class, () -> DateTimeUtil.parseDate(invalidApplicationDate3));
        assertThrows(DateTimeException.class, () -> DateTimeUtil.parseDate(invalidApplicationDate4));
        assertThrows(DateTimeException.class, () -> DateTimeUtil.parseDate(invalidApplicationDate5));
        assertThrows(DateTimeException.class, () -> DateTimeUtil.parseDate(invalidApplicationDate6));
        assertThrows(DateTimeException.class, () -> DateTimeUtil.parseDate(invalidApplicationDate7));

    }

    @Test
    public void parseDate_validDate_returnsCorrectDate() {
        int currentYear = LocalDate.now().getYear();

        LocalDate date1 = LocalDate.of(2019, 3, 1);
        LocalDate date2 = LocalDate.of(currentYear, 4, 2);

        // parse correctly
        assertEquals(DateTimeUtil.parseDate("1 3 2019"), date1);
        assertEquals(DateTimeUtil.parseDate("01 03 2019"), date1);
        assertEquals(DateTimeUtil.parseDate("1/3-2019"), date1);

        assertEquals(DateTimeUtil.parseDate("2/4"), date2);
    }
}
