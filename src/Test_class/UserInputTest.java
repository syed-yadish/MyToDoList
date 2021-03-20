package Test_class;

 // A class to test UserInput class
import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import UserInput_class.*;

import java.time.*;
import java.util.Locale;


public class UserInputTest {

 

    @Test
    public void testGiveTitle() {
        // Setup
        final String expectedResult = "task1";

        // Run the test
        final String result = UserInput.giveTitle();

        // Verify the results
        assertEquals(expectedResult, result);
    }


    @Test
    public void testGiveDueDate() {

        final LocalDate expectedResult = LocalDate.of(2022, 1, 1);

        // Run the test
        final LocalDate result = UserInput.giveDueDate();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGiveStatus() {

        final String expectedResult = "pending";

        // Run the test
        final String result = UserInput.giveStatus();

        // Verify the results
        assertEquals(expectedResult, result);
    }



    @Test
    public void testGiveProject() {
        // Setup
        final String expectedResult = "java1";

        // Run the test
        final String result = UserInput.giveProject();

        // Verify the results
        assertEquals(expectedResult, result);
    }
}