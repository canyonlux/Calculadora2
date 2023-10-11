
// Clase MainActivity
package com.example.calculadora;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private TextView resultTextView;
    private String input = "";
    private double result = 0;
    private Calculator calculator; // Instancia de la clase Calculator

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.textView3);
        calculator = new Calculator(); // Inicializa la instancia de Calculator

        // Asignar onClickListeners a los botones
        Button buttonSuma = findViewById(R.id.buttonsuma);
        Button buttonReinicio = findViewById(R.id.buttonreinicio);
        Button buttonIgual = findViewById(R.id.buttonigual);
        Button buttonMultiplicacion = findViewById(R.id.buttonmultiplicacion);

        buttonMultiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.handleMultiplicationClick(); // Llama al método de Calculator
                updateDisplay(); // Actualiza la vista
            }
        });

        buttonSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.handleOperatorClick("+"); // Llama al método de Calculator
                updateDisplay(); // Actualiza la vista
            }
        });

        buttonReinicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.handleClearClick(); // Llama al método de Calculator
                updateDisplay(); // Actualiza la vista
            }
        });

        buttonIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.handleEqualClick(); // Llama al método de Calculator
                updateDisplay(); // Actualiza la vista
            }
        });

        // Asignar onClickListeners a los botones numéricos (0-9)
        for (int i = 0; i <= 9; i++) {
            int buttonId = getResources().getIdentifier("button" + i, "id", getPackageName());
            Button button = findViewById(buttonId);
            final String digit = String.valueOf(i);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calculator.handleDigitClick(digit); // Llama al método de Calculator
                    updateDisplay(); // Actualiza la vista
                }
            });
        }


    }
    public void updateDisplay() {
        resultTextView.setText(calculator.getCurrentInput()); // Obtiene el estado actual de Calculator y lo muestra en la vista
    }
}





















