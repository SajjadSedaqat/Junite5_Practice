package sajjad.junite5.converter;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ConverterUtilTest {

    int[][] celsiusFahrenheitMapping = new int[][] { { 10, 50 }, { 40, 104 }, { 0, 32 } };

    @TestFactory
    Stream<DynamicTest> ensureThatCelsiusConvertsToFahrenheit() {
        return Arrays.stream(celsiusFahrenheitMapping).map(entry -> {
            // access celsius and fahrenheit from entry
            int celsius = entry[0];
            int fahrenheit = entry[1];
            return DynamicTest
                    .dynamicTest(celsius+" celsius is "+fahrenheit+" fahrenheit"
                            , ()->{
                        assertEquals(fahrenheit, ConverterUtil.convertCelsiusToFahrenheit(celsius));
                    });
            // return a dynamicTest which checks that the conversion from celsius to
            // fahrenheit is correct
        });

    }

    @TestFactory
    Stream<DynamicTest> ensureThatFahrenheitToCelsiusConverts() {
        // Task: Write a similar test fahrenheit to celsius
        return Arrays.stream(celsiusFahrenheitMapping)
                .map(entry ->{
                    int celsius = entry[0];
                    int fahrenheit = entry[1];

                    return DynamicTest.dynamicTest(fahrenheit +" fahrenheit is "+celsius+" celsius",
                            ()->{
                        assertEquals(celsius, ConverterUtil.convertFahrenheitToCelsius(fahrenheit));
                            });
                });
    }
}