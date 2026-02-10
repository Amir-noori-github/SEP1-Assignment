import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExtraTest extends AbstractParent {

    private static Calculator calculator = new Calculator();
    private final double DELTA = 0.001;

    @BeforeAll
    public static void testPowerOn() {
        calculator.powerOn();
    }

    @AfterAll
    public static void testPowerOff() {
        calculator.powerOff();
        calculator = null;
    }

    @BeforeEach
    public void testReset() {
        calculator.reset();
        assertEquals(0.0, calculator.getResult(), 0.001);
    }

    @ParameterizedTest(name = "Square of {0} should be {1}")
    @CsvSource({
            "2, 4",
            "4, 16",
            "5, 25"
    })
    public void testSquareParameterized(double input, double expected) {
        calculator.square(input);
        assertEquals(expected, calculator.getResult(), DELTA);
    }

    @ParameterizedTest(name = "Square root of {0} should be {1}")
    @CsvSource({
            "4, 2",
            "9, 3",
            "16, 4"
    })
    public void testSquareRootParameterized(double input, double expected) {
        calculator.squareRoot(input);
        assertEquals(expected, calculator.getResult(), DELTA);
    }

    @ParameterizedTest
    @CsvSource({ "-1", "-9", "-25" })
    @DisplayName("Negative square root throws exception")
    public void testSquareRootNegative(double input) {
        assertThrows(ArithmeticException.class, () -> calculator.squareRoot(input));
    }
}