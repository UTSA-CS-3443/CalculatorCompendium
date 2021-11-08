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
import javafx.stage.Stage;

public class ConversionController {
	
	@FXML
    private Button btnBack;

    @FXML
    void handleBack(ActionEvent event) {    	
    	try {

			Parent root = FXMLLoader.load(getClass().getResource("../view/Main.fxml"));
			((Stage) Main.stage).setScene(new Scene(root, 800, 800));
			((Stage) Main.stage).show();

		} catch (Exception e) {
			e.printStackTrace();
		}

    }

}
