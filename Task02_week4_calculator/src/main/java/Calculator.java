public class Calculator {

    private double result;

    public void reset() {
        result = 0.0;
    }

    public double getResult() {
        return result;
    }

    public void add(double n) {
        result = result + n;
    }

    public void subtract(double n) {
        result = result - n;
    }

    public void multiply(double n) {
        result = result * n;
    }

    public void divide(double n) {
        if (n == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        result = result / n;
    }

    public void square(double n) {
        result = n * n;
    }

    public void squareRoot(double n) {
        if (n < 0) {
            throw new ArithmeticException("Cannot take square root of negative number");
        }
        result = Math.sqrt(n);
    }

    public void powerOn() {
        result = 0.0;
    }

    public void powerOff() {
        // no action needed
    }
}