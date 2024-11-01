module dev.ilya.calculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens dev.ilya.calculator to javafx.fxml;
    exports dev.ilya.calculator;
}