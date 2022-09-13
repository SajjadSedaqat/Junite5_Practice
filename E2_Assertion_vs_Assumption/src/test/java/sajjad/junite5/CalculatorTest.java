package sajjad.junite5;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }


    @Test
    void testAdd() {
        int a = 5;
        int b = 2;

        int result = calculator.add(a, b);

        assertEquals(a + b, result);
    }

    @Test
    void testMultiply() {
        int a = 5;
        int b = 2;

        int additionResult = calculator.add(a, b);

        assertTrue(2 == additionResult);

        int multiplicationResult = calculator.multiply(a, b);

        assertEquals(a * b, multiplicationResult);
    }
}