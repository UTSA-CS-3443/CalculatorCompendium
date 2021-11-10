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

public class ScientificController {
	
    @FXML
    private Button btnBack;

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
