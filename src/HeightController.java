import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HeightController {
    @FXML
    private TextField inchesField;
    @FXML
    private TextField feetField;
    @FXML
    private TextField cmField;
    @FXML
    private Label usResult;
    @FXML
    private Label metricResult;
    @FXML
    private Button usToMetricClear;
    @FXML
    private Button metricToUsClear;


    @FXML
    private void handleMetricToUSConversion() {
        // Check if any of the input fields are empty
        if (inchesField.getText().isEmpty() || feetField.getText().isEmpty()) {
            showErrorDialog("Please enter values for both inches and feet.");
            return; // Exit the method if any field is empty
        }
        // Convert from inches and feet to centimeters
        double inches = Double.parseDouble(inchesField.getText());
        double feet = Double.parseDouble(feetField.getText());
        double cm = (feet * 30.48) + (inches * 2.54);
        // Display the result in the usResult label
        usResult.setText(String.format("Centimeters: %.2f", cm));
    }

    @FXML
    private void handleUSToMetricConversion() {
        // Check if the cmField is empty
        if (cmField.getText().isEmpty()) {
            showErrorDialog("Please enter a value for centimeters.");
            return; // Exit the method if the field is empty
        }
        // Convert from centimeters to inches and feet
        double cm = Double.parseDouble(cmField.getText());
        double inches = cm * 0.3937; // Convert cm to inches
        double feet = (int) (inches / 12); // Get the whole number of feet
        inches = inches % 12; // Get the remainder as inches
        // Display the result in the metricResult label
        metricResult.setText(String.format("Feet: %.2f, Inches: %.2f", feet,inches));
    }

    // Error message dialog
private void showErrorDialog(String message) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Warning");
    alert.setHeaderText("Required Fields Empty");
    alert.setContentText(message);
    alert.showAndWait();
}

    //    Clear buttons
    @FXML
    private void handleUstoMetricClear() {
        inchesField.clear();
        feetField.clear();
        cmField.clear();
        metricResult.setText(null);
    }
    @FXML
    private void handleMetricToUsClear(){
        inchesField.clear();
        feetField.clear();
        cmField.clear();
        usResult.setText(null);
    }

}
