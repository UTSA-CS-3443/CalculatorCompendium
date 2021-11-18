/**
 * ScientificController controls the Scientific Calculator view.
 * 
 * @author Estela V. Rodriguez-Greenfield (wgi663)
 */

package application.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import application.Main;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ScientificController {
	
    @FXML
    private Button btn2powerX;

    @FXML
    private Button btnDivide;

    @FXML
    private Button btnTimes;

    @FXML
    private Button btnCalculate;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnBackspace;

    @FXML
    private Button btnSquareRoot;

    @FXML
    private Button btnEuler;

    @FXML
    private Button btnDecimal;

    @FXML
    private Button btnMod;

    @FXML
    private Button btnXexpY;

    @FXML
    private Button btn10powerX;

    @FXML
    private Button btnMinus;

    @FXML
    private Button btnPlus;

    @FXML
    private Button btnSquare;

    @FXML
    private Button btnBack;

    @FXML
    private TextField txtInput;

    @FXML
    private Button btnFactorial;

    @FXML
    private Button btnPi;

    @FXML
    private Button btn8;

    @FXML
    private Button btn9;

    @FXML
    private Button btnSign;

    @FXML
    private Button btn6;

    @FXML
    private Button btn7;

    @FXML
    private Button btn4;

    @FXML
    private Button btn5;

    @FXML
    private Button btn2;

    @FXML
    private Button btn1OverX;

    @FXML
    private Button btn3;

    @FXML
    private Button btnlog;

    @FXML
    private Button btn0;

    @FXML
    private Button btn1;

    @FXML
    void handleClear(ActionEvent event) {

    }

    @FXML
    void handleBackspace(ActionEvent event) {

    }

    @FXML
    void handleCalculate(ActionEvent event) {

    }
	
    @FXML
    void handleBack(ActionEvent event) {    	
    	try {

			Parent root = FXMLLoader.load(getClass().getResource("../view/Main.fxml"));
			(Main.stage).setScene(new Scene(root, 800, 800));
			(Main.stage).show();

		} catch (Exception e) {
			e.printStackTrace();
		}

    }

}
