package com.example.lab_3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private double firstNumber = 0;
    private double secondNumber = 0;
    private String operator = "";
    private boolean isNewOperation = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);
        setButtonListeners();
    }

    private void setButtonListeners() {
        findViewById(R.id.button_clear).setOnClickListener(v -> clearText());
        findViewById(R.id.button_change_sign).setOnClickListener(v -> changeSign());
        findViewById(R.id.button_sqrt).setOnClickListener(v -> calculateSquareRoot());

        // New Delete Button Listener
        findViewById(R.id.button_delete).setOnClickListener(v -> deleteLastCharacter());

        // Numeric buttons
        int[] numberButtonIds = {
                R.id.button_0, R.id.button_1, R.id.button_2,
                R.id.button_3, R.id.button_4, R.id.button_5,
                R.id.button_6, R.id.button_7, R.id.button_8,
                R.id.button_9
        };
        for (int id : numberButtonIds) {
            findViewById(id).setOnClickListener(v -> appendToResult(((Button) v).getText().toString()));
        }

        // Operator buttons
        findViewById(R.id.button_add).setOnClickListener(v -> performOperation("+"));
        findViewById(R.id.button_subtract).setOnClickListener(v -> performOperation("-"));
        findViewById(R.id.button_multiply).setOnClickListener(v -> performOperation("*"));
        findViewById(R.id.button_divide).setOnClickListener(v -> performOperation("/"));

        // Equal button
        findViewById(R.id.button_equal).setOnClickListener(v -> calculateResult());
    }

    private void appendToResult(String number) {
        if (isNewOperation) {
            resultTextView.setText(number);
            isNewOperation = false;
        } else {
            resultTextView.append(number);
        }
    }

    private void performOperation(String op) {
        // If the operator is already set, we replace it with the new one
        if (!isNewOperation) {
            firstNumber = Double.parseDouble(resultTextView.getText().toString());
            operator = op; // Set the operator to the new one
            isNewOperation = true; // Set to true to indicate a new operation
        } else {
            // If we are in a new operation state, we just update the operator
            operator = op; // Update the operator directly
        }
    }

    private void calculateResult() {
        if (!operator.isEmpty() && !isNewOperation) {
            secondNumber = Double.parseDouble(resultTextView.getText().toString());
            double result;

            switch (operator) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "*":
                    result = firstNumber * secondNumber;
                    break;
                case "/":
                    if (secondNumber != 0) {
                        result = firstNumber / secondNumber;
                    } else {
                        resultTextView.setText("Error");
                        return;
                    }
                    break;
                default:
                    return;
            }

            resultTextView.setText(String.valueOf(result));
            operator = "";
            isNewOperation = true;
        }
    }

    private void calculateSquareRoot() {
        double number = Double.parseDouble(resultTextView.getText().toString());
        double result = Math.sqrt(number);
        resultTextView.setText(String.valueOf(result));
        isNewOperation = true;
    }

    private void clearText() {
        resultTextView.setText("0");
        firstNumber = 0;
        secondNumber = 0;
        operator = "";
        isNewOperation = true;
    }

    private void changeSign() {
        double number = Double.parseDouble(resultTextView.getText().toString());
        number = -number;
        resultTextView.setText(String.valueOf(number));
    }

    // Method to delete the last character from the result
    private void deleteLastCharacter() {
        String currentText = resultTextView.getText().toString();
        if (currentText.length() > 1) {
            resultTextView.setText(currentText.substring(0, currentText.length() - 1));
        } else {
            resultTextView.setText("0");
        }
    }
}
