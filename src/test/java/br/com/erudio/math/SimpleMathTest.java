package br.com.erudio.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test Math Operations in SimpleMath Class")
class SimpleMathTest {

	@BeforeAll
	static void setup() {
		System.out.println("Running @BeforeAll method!");
	}

	@AfterAll
	static void cleanup() {
		System.out.println("Running @AfterAll method!");
	}

	@BeforeEach
	void beforeEachMethod() {
		System.out.println("Running @@BeforeEach method!");
	}

	@AfterEach
	void afterEachMethod() {
		System.out.println("Running @@AfterEach method!");
	}

	@Test
	@DisplayName("Test 6.2 + 2 = 8.2")
	void testSum_When_SixDotTwoIsAddedByTwo_ShouldReturnEightDotTwo() {
		SimpleMath math = new SimpleMath();
		double firstNumber = 6.2D;
		double secondNumber = 2D;

		Double actual = math.sum(firstNumber, secondNumber);

		double expected = 8.2D;
		assertEquals(expected, actual, () -> firstNumber + "+" + secondNumber + " did not produce " + expected + "!");
	}

	@Test
	@DisplayName("Test 6.2 - 2 = 4.2")
	void testSubtraction() {
		SimpleMath math = new SimpleMath();
		double firstNumber = 6.2D;
		double secondNumber = 2D;

		Double actual = math.subtraction(firstNumber, secondNumber);

		double expected = 4.2D;
		assertEquals(expected, actual, () -> firstNumber + "-" + secondNumber + " did not produce " + expected + "!");
	}

	@Test
	@DisplayName("Test 3 * 5 = 15")
	void testMultiplication() {
		SimpleMath math = new SimpleMath();
		double firstNumber = 3D;
		double secondNumber = 5D;

		Double actual = math.multiplication(firstNumber, secondNumber);

		double expected = 15D;
		assertEquals(expected, actual, () -> firstNumber + "-" + secondNumber + " did not produce " + expected + "!");
	}

	@Test
	@DisplayName("Test 49 / 2 = 24.5")
	void testDivision() {
		SimpleMath math = new SimpleMath();
		double firstNumber = 49D;
		double secondNumber = 2D;

		Double actual = math.division(firstNumber, secondNumber);

		double expected = 24.5D;
		assertEquals(expected, actual, () -> firstNumber + "-" + secondNumber + " did not produce " + expected + "!");
	}

	// Disables test and show message
	// @Disabled("TODO: We still need to work on it")
	@Test
	@DisplayName("Test division by zero")
	void testDivision_When_FirstNumberIsDividedByZero_ShouldThrowAritmeticException() {
		SimpleMath math = new SimpleMath();

		double firstNumber = 7D;
		double secondNumber = 0D;

		var expectedMessage = "Impossible to divide by zero!";

		ArithmeticException actual = assertThrows(ArithmeticException.class, () -> {
			math.division(firstNumber, secondNumber);
		}, () -> "Division by zero should throw an ArithmeticException!");

		assertEquals(expectedMessage, actual.getMessage(), () -> "Unexpected exception message!");
	}

	@Test
	@DisplayName("Test (7 + 8) / 2 = 7.5")
	void testMean() {
		SimpleMath math = new SimpleMath();
		double firstNumber = 7D;
		double secondNumber = 8D;

		Double actual = math.mean(firstNumber, secondNumber);

		double expected = 7.5D;
		assertEquals(expected, actual, () -> firstNumber + "-" + secondNumber + " did not produce " + expected + "!");
	}

	@Test
	@DisplayName("Test Square Root of 64 = 8")
	void testSquareRoot() {
		SimpleMath math = new SimpleMath();

		double number = 64D;
		Double actual = math.squareRoot(number);

		double expected = 8D;
		assertEquals(expected, actual, () -> number + " square root did not produce " + expected + "!");
	}

	@DisplayName("Display Name")
	@Test
	void testABCD_When_XYZ_Should() {
		// Given / Arrange
		// When / Act
		// Then / Assert
	}

}
