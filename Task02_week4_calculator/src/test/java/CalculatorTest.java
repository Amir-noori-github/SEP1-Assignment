import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    private Calculator calculator = new Calculator();
    private final double DELTA = 0.001;

    @BeforeEach
    public void clearCalculator() {
        calculator.reset();
    }

    @Test
    public void testAdd() {
        calculator.add(1);
        calculator.add(2);
        assertEquals(3.0, calculator.getResult(), DELTA);
    }

    @Test
    public void testSubtract() {
        calculator.add(10);
        calculator.subtract(2);
        assertEquals(8.0, calculator.getResult(), DELTA);
    }

    @Test
    @DisplayName("Test division 8 / 2")
    public void testDivide() {
        calculator.add(8);
        calculator.divide(2);
        assertEquals(4.0, calculator.getResult(), DELTA);
    }

    @Test
    @DisplayName("Test division by zero")
    public void testDivideByZero() {
        ArithmeticException exception =
                assertThrows(ArithmeticException.class, () -> calculator.divide(0));
        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    @Test
    public void testMultiply() {
        calculator.add(5);
        calculator.multiply(3);
        assertEquals(15.0, calculator.getResult(), DELTA);
    }

    @Test
    public void testSquare() {
        calculator.square(6);
        assertEquals(36.0, calculator.getResult(), DELTA);
    }

    @Test
    public void testSquareRoot() {
        calculator.squareRoot(81);
        assertEquals(9.0, calculator.getResult(), DELTA);
    }

    @Test
    public void testSquareRootNegative() {
        assertThrows(ArithmeticException.class, () -> calculator.squareRoot(-9));
    }

    @Test
    public void testReset() {
        calculator.add(100);
        calculator.reset();
        assertEquals(0.0, calculator.getResult(), DELTA);
    }

    @Test
    public void testPowerOn() {
        calculator.add(50);
        calculator.powerOn();
        assertEquals(0.0, calculator.getResult(), DELTA);
    }
}