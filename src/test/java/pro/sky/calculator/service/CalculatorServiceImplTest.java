package pro.sky.calculator.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.calculator.service.impl.CalculatorServiceImpl;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceImplTest {

    private final CalculatorService calculatorService = new CalculatorServiceImpl();

    @Test
    public void calculateSum() {
        Integer num1 = 10;
        Integer num2 = 20;
        Integer expectedResult = 30;

        Assertions.assertEquals(expectedResult, calculatorService.plus(num1, num2));
    }

    @Test
    public void calculateSumWithNegativeNumbers() {
        Integer num1 = -10;
        Integer num2 = -20;
        Integer expectedResult = -30;

        Assertions.assertEquals(expectedResult, calculatorService.plus(num1, num2));
    }

    @Test
    public void calculateSubtraction() {
        Integer num1 = 10;
        Integer num2 = 20;
        Integer expectedResult = num1 - num2;

        Assertions.assertEquals(expectedResult, calculatorService.minus(num1, num2));
    }

    @Test
    public void calculateMultiply() {
        Integer num1 = 10;
        Integer num2 = 20;
        Integer expectedResult = num1 * num2;

        Assertions.assertEquals(expectedResult, calculatorService.multiply(num1, num2));
    }

    @Test
    public void calculateDivide() {
        Integer num1 = 30;
        Integer num2 = 3;
        Integer expectedResult = num1 / num2;

        Assertions.assertEquals(expectedResult, calculatorService.divide(num1, num2));
    }

    @Test
    public void calculateDivisionByZero() {
        Integer num1 = 30;
        Integer num2 = 0;

        Assertions.assertThrows(IllegalArgumentException.class, () -> calculatorService.divide(num1, num2));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForPlusTests")
    public void operationPlusGenerateCorrectOutput(Integer num1, Integer num2, Integer expectedInOutput) {
        String actual = calculatorService.plus(num1, num2).toString();
        assertEquals(true, actual.contains(expectedInOutput.toString()));
    }

    public static Stream<Arguments> provideParamsForPlusTests() {
        return Stream.of(
                Arguments.of(5, 1 , 6),
                Arguments.of(0, 0 , 0)
        );
    }
    @ParameterizedTest
    @MethodSource("provideParamsForMinusTests")
    public void operationMinusGenerateCorrectOutput(Integer num1, Integer num2, Integer expectedInOutput) {
        String actual = calculatorService.minus(num1, num2).toString();
        assertEquals(true, actual.contains(expectedInOutput.toString()));
    }

    public static Stream<Arguments> provideParamsForMinusTests() {
        return Stream.of(
                Arguments.of(1, 1, 0),
                Arguments.of(2, 3, -1)
        );
    }
}

