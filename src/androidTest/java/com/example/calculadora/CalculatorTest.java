package com.example.calculadora;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testAddition() {
        calculator.handleDigitClick("2");
        calculator.handleOperatorClick("+");
        calculator.handleDigitClick("3");
        calculator.handleEqualClick();
        assertEquals("5.0", calculator.getCurrentInput());
    }

    @Test
    public void testMultiplication() {
        calculator.handleDigitClick("2");
        calculator.handleMultiplicationClick();
        calculator.handleDigitClick("3");
        calculator.handleEqualClick();
        assertEquals("6.0", calculator.getCurrentInput());
    }
    @Test
    public void testMultiplicatione() {
        Calculator calculator = new Calculator();

        // Realiza una operación de multiplicación
        calculator.handleDigitClick("2");
        calculator.handleMultiplicationClick();
        calculator.handleDigitClick("3");
        calculator.handleEqualClick();

        // Verifica si el resultado es igual a 6
        assertEquals("6.0", calculator.getCurrentInput());
    }

}
