/**
 * MainController handles the Main view.
 * 
 * @author Estela V. Rodriguez-Greenfield (wgi663) 
 */

package application.controller;

import application.Main;
import application.model.Fact;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainController {

	@FXML
	private Button btnConversion;

	@FXML
	private Button btnMatrix;

	@FXML
	private Button btnTax;

	@FXML
	private Button btnScientific;

	@FXML
	private Button btnFacts;
	
    @FXML
    private Label lblFact;
    
    @FXML
    private Button btnSnake;
    
	@FXML
	/**
	 * This method handles the view change for the calculators.
	 * 
	 * @param event, an ActionEvent
	 */
	void handle(ActionEvent event) {

		String path = "";
		Object click = event.getSource();
		String btnClicked = click.toString().substring((click.toString().indexOf('=', 0) + 1),
				(click.toString().indexOf(',', 0)));

		switch (btnClicked) {
		case "btnScientific":
			path = "../view/ScientificCalcView.fxml";
			break;
		case "btnConversion":
			path = "../view/ConversionView.fxml";
			break;
		case "btnMatrix":
			path = "../view/MatrixView.fxml";
			break;
		case "btnTax":
			path = "../view/TaxView.fxml";
			break;
		}

		try {

			Parent root = FXMLLoader.load(getClass().getResource(path));
			(Main.stage).setScene(new Scene(root, 800, 800));
			(Main.stage).show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@FXML
	/**
	 * This method handles the Random Math Fact button, displaying a random math fact from a file.
	 * 
	 * @param event, an ActionEvent
	 */
    void handleFacts(ActionEvent event) {
		Fact mathFacts = new Fact();
		mathFacts.loadFacts("data/mathfacts.csv");
		String fact = mathFacts.randomFact();
		lblFact.setText(fact);
    }
	
    @FXML
    /**
     * This method handles loading the view for the snake game.
     * 
     * @param event, an ActionEvent
     */
    void handleSnake(ActionEvent event) {    	
    	try {

			Parent root = FXMLLoader.load(getClass().getResource("../view/SnakeView.fxml"));
			(Main.stage).setScene(new Scene(root, 800, 800));
			(Main.stage).show();

		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}
