package dev.ilya.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalculatorController {
    @FXML
    public Label result;
    private double resultD = 0.0;
    private boolean start = true;
    private StringBuilder inputBuffer = new StringBuilder();
    private String currOperator = "";
    private Calculator calculator = new Calculator();
    private double num1 = 0.0;
    private double num2 = 0.0;
    private int counter = 0;

    public CalculatorController() {
    }

    @FXML
    protected void onOperandButtonClick(ActionEvent event) {
        if (start) {
            result.setText("");
            start = false;
        }

        String value = ((Button) event.getSource()).getText();
        inputBuffer.append(value);
        result.setText(inputBuffer.toString());
        if (counter == 0) {
            num1 = Double.parseDouble(inputBuffer.toString());
        } else {
            num2 = Double.parseDouble(inputBuffer.toString());
        }
    }

    @FXML
    protected void onOperatorButtonClick(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();
        result.setText(inputBuffer.append(value).toString());
        inputBuffer.setLength(0);
        if (!value.equals("=")) {
            currOperator = value;
            counter++;
            switch (currOperator) {
                case "C":
                    result.setText("");
                    inputBuffer.setLength(0);
                    resultD = 0;
                    currOperator = "";
                    num1 = 0;
                    num2 = 0;
                    counter = 0;
            }
        } else {
            switch (currOperator) {
                case "+", "-", "*", "/" -> {
                    resultD = calculator.calculate(num1, num2, currOperator);
                    inputBuffer.setLength(0);
                }
            }
            result.setText(String.format("%.2f", resultD));
            num1 = resultD;
            counter = 0;
            start = true;
        }
    }
}
