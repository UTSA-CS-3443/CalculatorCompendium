/**
 * ConversionContoller controls the Conversion Calculator view.
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class ConversionController {
	
	@FXML
    private Button btnBack;
	
	@FXML
    private ComboBox<?> ddConvertTo;

    @FXML
    private ComboBox<?> ddConversionType;

    @FXML
    private ComboBox<?> ddConvertFrom;
   
    @FXML
    private TextField txtConvertFrom;

    @FXML
    private TextField txtConvertTo;
    
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
