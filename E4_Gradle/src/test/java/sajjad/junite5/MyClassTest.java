package sajjad.junite5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyClassTest {
    MyClass tester;

    @BeforeEach
    void setUp() {
        tester = new MyClass();
    }

/*    @Test
    void testExceptionIsThrown() {
        assertThrows(IllegalArgumentException.class, () -> tester.multiply(1000, 5));
    }

    @Test
    void testMultiply() {
        assertEquals(50, tester.multiply(10, 5), "10 x 5 must be 50");
    }*/


    //Using assert all to check both condition at the same time
    @Test
    void testAll() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> tester.multiply(1000, 5)),
                () -> assertEquals(50, tester.multiply(10, 5), "10 * must be 50")
        );

    }
}