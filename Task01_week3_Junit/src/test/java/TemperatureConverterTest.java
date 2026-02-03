import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TemperatureConverterTest {

    private TemperatureConverter converter;

    @BeforeEach
    void setUp() {
        converter = new TemperatureConverter();
    }

    @Test
    void testFahrenheitToCelsius() {
        assertEquals(0, converter.fahrenheitToCelsius(32), 0.001);
        assertEquals(100, converter.fahrenheitToCelsius(212), 0.001);
        assertEquals(37.777, converter.fahrenheitToCelsius(100), 0.001);
        assertEquals(-23.333, converter.fahrenheitToCelsius(-10), 0.001);
    }

    @Test
    void testCelsiusToFahrenheit() {
        assertEquals(32, converter.celsiusToFahrenheit(0), 0.001);
        assertEquals(212, converter.celsiusToFahrenheit(100), 0.001);
        assertEquals(98.6, converter.celsiusToFahrenheit(37), 0.001);
        assertEquals(14.0, converter.celsiusToFahrenheit(-10), 0.001);
    }

    @Test
    void testIsExtremeTemperature() {
        assertTrue(converter.isExtremeTemperature(-50));
        assertTrue(converter.isExtremeTemperature(60));
        assertTrue(converter.isExtremeTemperature(55));
        assertTrue(converter.isExtremeTemperature(-50));

        assertFalse(converter.isExtremeTemperature(20));
        assertFalse(converter.isExtremeTemperature(30));
        assertFalse(converter.isExtremeTemperature(0));
        assertFalse(converter.isExtremeTemperature(-40));

    }
}