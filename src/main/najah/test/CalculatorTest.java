package main.najah.test;

import main.najah.code.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(OrderAnnotation.class)
@DisplayName("Calculator Tests")
public class CalculatorTest {
    Calculator calc;

    @BeforeAll
    static void initAll() {
        System.out.println("[CalculatorTest] All tests starting");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("[CalculatorTest] All tests finished");
    }

    @BeforeEach
    void init() {
        calc = new Calculator();
        System.out.println("[CalculatorTest] Setup complete");
    }

    @AfterEach
    void after() {
        System.out.println("[CalculatorTest] Test done");
    }

    @Order(1)
    @Test
    @DisplayName("Test addition with multiple values")
    void testAddition() {
        assertEquals(10, calc.add(2, 3, 5));
    }

    @Order(2)
    @Test
    @DisplayName("Test divide by zero throws exception")
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> calc.divide(5, 0));
    }

    @Order(3)
    @ParameterizedTest
    @CsvSource({"5,120", "0,1"})
    @DisplayName("Test factorial with valid inputs")
    void testFactorialValid(int input, int expected) {
        assertEquals(expected, calc.factorial(input));
    }

    @Order(4)
    @Test
    @DisplayName("Test factorial with negative input")
    void testFactorialNegative() {
        assertThrows(IllegalArgumentException.class, () -> calc.factorial(-1));
    }

    @Order(5)
    @Test
    @Timeout(1)
    @DisplayName("Timeout test for factorial")
    void testFactorialTimeout() {
        calc.factorial(10);
    }

    @Order(6)
    @Test
    @Disabled("Fix: Expected value was incorrect, update expected value to pass")
    @DisplayName("Disabled failing test")
    void testFailing() {
        assertEquals(100, calc.add(40, 50)); // This will fail
    }
}
