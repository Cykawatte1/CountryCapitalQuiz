package org.example.countrycapitalquiz;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class QuizController {

    private Europa currEurope;

    @FXML
    private Label countryLabel;

    @FXML
    private Label solutionLabel;

    @FXML
    private TextField solutionTextField;

    /**
     * Method updates the game, new Country gets selected
     */
    public void updateCountry() {
        currEurope = new Europa();
        countryLabel.setText("Whats the Capital of : " + currEurope.getCountry());
    }

    public void updateSolution() {
        String input = solutionTextField.getText();
        if(input.equalsIgnoreCase(currEurope.getCapital())) {
            solutionLabel.setText("RIGHT answere! ✅");
        } else {
            solutionLabel.setText("WRONG answere! ❌");
        }
    }
}
