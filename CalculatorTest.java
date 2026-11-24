import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        // TODO 1: Create an object of Calculator class
        calculator = new Calculator();
    }

    @Test
    public void testAddition() {
        // TODO 2: Call add() with two numbers
        int result = calculator.add(5, 3);

        // TODO 3: Verify result using assertEquals()
        assertEquals(8, result);
    }

    @Test
    public void testSubtraction() {
        // TODO 4: Call subtract() with two numbers
        int result = calculator.subtract(10, 4);

        // TODO 5: Verify expected result
        assertEquals(6, result);
    }

    @Test
    public void testMultiplication() {
        // TODO 6: Call multiply() with two numbers
        int result = calculator.multiply(6, 7);

        // TODO 7: Verify expected result
        assertEquals(42, result);
    }

    @Test
    public void testDivision() {
        // TODO 8: Call divide() with two non-zero numbers
        double result = calculator.divide(10.0, 4.0);

        // TODO 9: Verify expected result using assertEquals()
        // Use a delta for double values
        assertEquals(2.5, result, 0.0001);
    }

    @Test
    public void testDivisionByZero() {
        // TODO 10: Verify IllegalArgumentException
        // Hint: Use assertThrows()
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(10.0, 0.0));
    }

    @Test
    public void testAdditionWithNegativeNumbers() {
        // TODO 11: Test addition with negative numbers
        int result = calculator.add(-5, -3);

        // TODO 12: Verify expected result
        assertEquals(-8, result);
    }

    @Test
    public void testMultiplicationByZero() {
        // TODO 13: Verify multiplication by zero
        int result = calculator.multiply(5, 0);
        assertEquals(0, result);
    }

}