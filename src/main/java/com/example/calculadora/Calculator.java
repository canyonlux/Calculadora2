/** Clase Calculator
 *
 */
package com.example.calculadora;

import android.widget.TextView;

public class Calculator {
    private String input = "";
    private double result = 0;

    public void handleMultiplicationClick() {
        if (!input.isEmpty()) {

            input +="*";

        }

    }


    /**
     * Maneja el clic en un dígito numérico.
     *
     * @param digit El dígito numérico presionado.
     */
    public void handleDigitClick(String digit) {

        input += digit;
    }
    /**
     * Maneja el clic en un operador (+, -, *, /).
     *
     * @param operator El operador presionado.
     */
    public void handleOperatorClick(String operator) {
        if (!input.isEmpty()) {

            input += operator;
        }

    }
    /**
     * Maneja el clic en el botón de reinicio, borrando el estado actual.
     */
    public void handleClearClick() {
        input = "";
        result = 0;
    }
    /**
     * Maneja el clic en el botón de igual, realizando el cálculo.
     */

    public void handleEqualClick() {
        // Realiza el último cálculo pendiente
        result = calculate();
        input = Double.toString(result);
    }

    /**
     * Obtiene el estado actual de la calculadora.
     *
     * @return El contenido actual de la pantalla de la calculadora.
     */
    public String getCurrentInput() {
        return input;
    }
    private double calculate() {
        String[] parts = input.split("[+\\-*/]");
        if (parts.length != 2) {
            return result; // Si no hay dos operandos, retorna el resultado anterior
        }

        double operand1 = Double.parseDouble(parts[0]);
        double operand2 = Double.parseDouble(parts[1]);

        if (input.contains("+")) {
            return operand1 + operand2;
        } else if (input.contains("-")) {
            return operand1 - operand2;
        } else if (input.contains("*")) {
            return operand1 * operand2;
        } else if (input.contains("/")) {
            if (operand2 != 0) {
                return operand1 / operand2;
            } else {
                return Double.NaN; // División por cero
            }
        }

        return result; // Si no se reconoce el operador, retorna el resultado anterior
    }
}
