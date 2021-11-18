/**
 * MatrixController controls the Matrix Calculator view.
 * 
 * @author Estela V. Rodriguez-Greenfield (wgi663)
 */

package application.controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MatrixController {

	  	@FXML
	    private Button btnClear;

	    @FXML
	    private TextField txtA23;

	    @FXML
	    private TextField txtB22;

	    @FXML
	    private TextField txtB23;

	    @FXML
	    private TextField txtA21;

	    @FXML
	    private TextField txtA22;

	    @FXML
	    private TextField txtB21;

	    @FXML
	    private Button btnBack;

	    @FXML
	    private Button btnAMinusB;

	    @FXML
	    private Button btnATimesB;

	    @FXML
	    private TextField txtA31;

	    @FXML
	    private Button btnAPlusB;

	    @FXML
	    private TextField txtA12;

	    @FXML
	    private TextField txtB11;

	    @FXML
	    private TextField txtB33;

	    @FXML
	    private TextField txtA13;

	    @FXML
	    private TextField txtB12;

	    @FXML
	    private TextField txtA32;

	    @FXML
	    private TextField txtB31;

	    @FXML
	    private TextField txtA11;

	    @FXML
	    private TextField txtA33;

	    @FXML
	    private TextField txtB32;

	    @FXML
	    private TextField txtB13;

	    @FXML
	    private TextArea txtResult;

	    @FXML
	    void handleATimesB(ActionEvent event) {

	    }

	    @FXML
	    void handleAPlusB(ActionEvent event) {

	    }

	    @FXML
	    void handleAMinusB(ActionEvent event) {

	    }

	    @FXML
	    void handleClear(ActionEvent event) {
	    	//Clear results
			txtResult.setText("Result...");

			//Clear Matrix A
			txtA11.clear();
			txtA12.clear();
			txtA13.clear();
			txtA21.clear();
			txtA22.clear();
			txtA23.clear();
			txtA31.clear();
			txtA32.clear();
			txtA33.clear();

			//Clear Matrix B
			txtB11.clear();
			txtB12.clear();
			txtB13.clear();
			txtB21.clear();
			txtB22.clear();
			txtB23.clear();
			txtB31.clear();
			txtB32.clear();
			txtB33.clear();
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
