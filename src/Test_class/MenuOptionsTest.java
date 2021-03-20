package Test_class;

// Test method to test MenuOptions class

import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


import Main_class.*;
import Task_class.*;
import UserInput_class.*;


public class MenuOptionsTest {


	@Test
	public void testCountTasksMarkedDone() {
		// Setup
		final long expectedResult = 0L;

		// Run the test
		final long result = MenuOptions.tasksDone();

		// Verify the results
		assertEquals(expectedResult, result);
	}

	@Test
	public void testCountTasksMarkedNotDone() {
		// Setup
		final long expectedResult = 0L;

		// Run the test
		final long result = MenuOptions.tasksNotDone();

		// Verify the results
		assertEquals(expectedResult, result);
	}
}