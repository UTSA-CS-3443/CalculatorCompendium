/**
 * ConversionContoller controls the Conversion Calculator view.
 * 
 * @author Estela V. Rodriguez-Greenfield (wgi663)
 * 
 * DEMO
 */

package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class ConversionController implements Initializable{
	
	@FXML
    private Button btnBack;
	
	@FXML
    private ComboBox<String> ddConvertTo;

    @FXML
    private ComboBox<String> ddConversionType;

    @FXML
    private ComboBox<String> ddConvertFrom;
   
    @FXML
    private TextField txtConvertFrom;

    @FXML
    private TextField txtConvertTo;
    
    
    
    @FXML
    public void initialize(URL location, ResourceBundle resources) {
    	ddConversionType.getItems().clear();
    	ddConversionType.getItems().addAll("Distance", "Mass");
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
    
    public void conversionType(ActionEvent event) {
    	String type = ddConversionType.getSelectionModel().getSelectedItem();
    	txtConvertFrom.clear();
    	txtConvertTo.clear();
    	System.out.println(type);
    	
    	if (type.equals("Distance")) {
    		//System.out.println("if statement distance");
    		ddConvertFrom.getItems().clear();
    		ddConvertFrom.getItems().addAll("Miles (m)", "Kilometers (km)");
    		ddConvertTo.getItems().clear();
    		ddConvertTo.getItems().addAll("Miles (m)", "Kilometers (km)");
    	}
    	else if (type.equals("Mass")) {
    		//System.out.println("if statement mass");
    		ddConvertFrom.getItems().clear();
    		ddConvertFrom.getItems().addAll("Pounds (lbs)", "Kilograms (kg)");
    		ddConvertTo.getItems().clear();
    		ddConvertTo.getItems().addAll("Pounds (lbs)", "Kilograms (kg)");
    	}
    }
    
    
    
    
    
    
    @FXML
    public void handleCalculate(ActionEvent event) {
    	String type = ddConversionType.getSelectionModel().getSelectedItem();
    	
    	//********************************************************************************************************************************************************************************
    	//                                                                     DISTANCE
    	//********************************************************************************************************************************************************************************
    	if (type.equals("Distance")) {
    		if (ddConvertFrom.getSelectionModel().getSelectedItem().equals("Miles (m)") && ddConvertTo.getSelectionModel().getSelectedItem().equals("Kilometers (km)")){
    			double miles = Double.parseDouble(txtConvertFrom.getText());
    			double kilometers = miles * 1.609;
    			txtConvertTo.setText("" + kilometers);
    		}
    		else if (ddConvertFrom.getSelectionModel().getSelectedItem().equals("Kilometers (km)") && ddConvertTo.getSelectionModel().getSelectedItem().equals("Miles (m)")) {
    			double kilometers = Double.parseDouble(txtConvertFrom.getText());
    			double miles = kilometers / 1.609;
    			txtConvertTo.setText("" + miles);
    		}
    	}
    	
    	
    	
    	//********************************************************************************************************************************************************************************
    	//                                                                     MASS
    	//********************************************************************************************************************************************************************************
    	
    	if (type.equals("Mass")) {
    		if (ddConvertFrom.getSelectionModel().getSelectedItem().equals("Pounds (lbs)") && ddConvertTo.getSelectionModel().getSelectedItem().equals("Kilograms (kg)")) {
    			double pounds = Double.parseDouble(txtConvertFrom.getText());
    			double kilograms = pounds * 0.45359237;
    			txtConvertTo.setText("" + kilograms);
    		}
    		else if (ddConvertFrom.getSelectionModel().getSelectedItem().equals("Kilograms (kg)") && ddConvertTo.getSelectionModel().getSelectedItem().equals("Pounds (lbs)")) {
    			double kilograms = Double.parseDouble(txtConvertFrom.getText());
    			double pounds = kilograms / 0.45359237;
    			txtConvertTo.setText("" + pounds);
    		}
    	}
    	
    	
    	
    	
    }
    

}
