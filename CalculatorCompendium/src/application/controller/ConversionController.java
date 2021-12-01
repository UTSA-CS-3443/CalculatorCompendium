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
    		ddConvertFrom.getItems().addAll("Miles (mi)", "Kilometers (km)", "Centimeters (cm)", "Meters (m)");
    		ddConvertTo.getItems().clear();
    		ddConvertTo.getItems().addAll("Miles (mi)", "Kilometers (km)", "Centimeters (cm)", "Meters (m)");
    	}
    	else if (type.equals("Mass")) {
    		//System.out.println("if statement mass");
    		ddConvertFrom.getItems().clear();
    		ddConvertFrom.getItems().addAll("Pounds (lbs)", "Kilograms (kg)", "Ounces (oz)", "Grams (g)");
    		ddConvertTo.getItems().clear();
    		ddConvertTo.getItems().addAll("Pounds (lbs)", "Kilograms (kg)", "Ounces (oz)", "Grams (g)");
    	}
    }
    
    
    
    
    
    
    @FXML
    public void handleCalculate(ActionEvent event) {
    	String type = ddConversionType.getSelectionModel().getSelectedItem();
    	
    	//********************************************************************************************************************************************************************************
    	//                                                                     DISTANCE
    	//********************************************************************************************************************************************************************************
    	if (type.equals("Distance")) {
    		if (ddConvertFrom.getSelectionModel().getSelectedItem().equals("Miles (mi)") && ddConvertTo.getSelectionModel().getSelectedItem().equals("Kilometers (km)")){
    			double miles = Double.parseDouble(txtConvertFrom.getText());
    			double kilometers = miles * 1.609;
    			txtConvertTo.setText("" + kilometers);
    		}
    		
    		else if (ddConvertFrom.getSelectionModel().getSelectedItem().equals("Miles (mi)") && ddConvertTo.getSelectionModel().getSelectedItem().equals("Meters (m)")){
    			double miles = Double.parseDouble(txtConvertFrom.getText());
    			double meters = miles * 1609.34;
    			txtConvertTo.setText("" + meters);
    		}
    		
    		else if (ddConvertFrom.getSelectionModel().getSelectedItem().equals("Miles (mi)") && ddConvertTo.getSelectionModel().getSelectedItem().equals("Centimeters (cm)")){
    			double miles = Double.parseDouble(txtConvertFrom.getText());
    			double centimeters = miles * 160934;
    			txtConvertTo.setText("" + centimeters);
    		}
    		
    		else if (ddConvertFrom.getSelectionModel().getSelectedItem().equals("Kilometers (km)") && ddConvertTo.getSelectionModel().getSelectedItem().equals("Miles (mi)")) {
    			double kilometers = Double.parseDouble(txtConvertFrom.getText());
    			double miles = kilometers / 1.609;
    			txtConvertTo.setText("" + miles);
    		}
    		
    		else if (ddConvertFrom.getSelectionModel().getSelectedItem().equals("Kilometers (km)") && ddConvertTo.getSelectionModel().getSelectedItem().equals("Meters (m)")) {
    			double kilometers = Double.parseDouble(txtConvertFrom.getText());
    			double meters = kilometers * 1000;
    			txtConvertTo.setText("" + meters);
    		}
    		
    		else if (ddConvertFrom.getSelectionModel().getSelectedItem().equals("Kilometers (km)") && ddConvertTo.getSelectionModel().getSelectedItem().equals("Centimeters (cm)")) {
    			double kilometers = Double.parseDouble(txtConvertFrom.getText());
    			double centimeters = kilometers * 100000;
    			txtConvertTo.setText("" + centimeters);
    		}
    		
    		else if (ddConvertFrom.getSelectionModel().getSelectedItem().equals("Meters (m)") && ddConvertTo.getSelectionModel().getSelectedItem().equals("Kilometers (km)")) {
    			double meters = Double.parseDouble(txtConvertFrom.getText());
    			double kilometers = meters / 1000;
    			txtConvertTo.setText("" + kilometers);
    		}
    		
    		else if (ddConvertFrom.getSelectionModel().getSelectedItem().equals("Meters (m)") && ddConvertTo.getSelectionModel().getSelectedItem().equals("Miles (mi)")) {
    			double meters = Double.parseDouble(txtConvertFrom.getText());
    			double miles = meters / 1609;
    			txtConvertTo.setText("" + miles);
    		}
    		
    		else if (ddConvertFrom.getSelectionModel().getSelectedItem().equals("Meters (m)") && ddConvertTo.getSelectionModel().getSelectedItem().equals("Centimeters (cm)")) {
    			double meters = Double.parseDouble(txtConvertFrom.getText());
    			double centimeters = meters * 100;
    			txtConvertTo.setText("" + centimeters);
    		}
    		
    		else if (ddConvertFrom.getSelectionModel().getSelectedItem().equals("Centimeters (cm)") && ddConvertTo.getSelectionModel().getSelectedItem().equals("Kilometers (km)")) {
    			double centimeters = Double.parseDouble(txtConvertFrom.getText());
    			double kilometers = centimeters / 100000;
    			txtConvertTo.setText("" + kilometers);
    		}
    		
    		else if (ddConvertFrom.getSelectionModel().getSelectedItem().equals("Centimeters (cm)") && ddConvertTo.getSelectionModel().getSelectedItem().equals("Miles (mi)")) {
    			double centimeters = Double.parseDouble(txtConvertFrom.getText());
    			double miles = centimeters / 160934;
    			txtConvertTo.setText("" + miles);
    		}
    		
    		else if (ddConvertFrom.getSelectionModel().getSelectedItem().equals("Centimeters (cm)") && ddConvertTo.getSelectionModel().getSelectedItem().equals("Meters (m)")) {
    			double centimeters = Double.parseDouble(txtConvertFrom.getText());
    			double meters = centimeters / 1000;
    			txtConvertTo.setText("" + meters);
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
    		
    		else if (ddConvertFrom.getSelectionModel().getSelectedItem().equals("Pounds (lbs)") && ddConvertTo.getSelectionModel().getSelectedItem().equals("Ounces (oz)")) {
    			double pounds = Double.parseDouble(txtConvertFrom.getText());
    			double ounces = pounds * 16;
    			txtConvertTo.setText("" + ounces);
    		}
    		
    		else if (ddConvertFrom.getSelectionModel().getSelectedItem().equals("Pounds (lbs)") && ddConvertTo.getSelectionModel().getSelectedItem().equals("Grams (g)")) {
    			double pounds = Double.parseDouble(txtConvertFrom.getText());
    			double grams = pounds * 453.592;
    			txtConvertTo.setText("" + grams);
    		}
    		
    		
    		else if (ddConvertFrom.getSelectionModel().getSelectedItem().equals("Kilograms (kg)") && ddConvertTo.getSelectionModel().getSelectedItem().equals("Pounds (lbs)")) {
    			double kilograms = Double.parseDouble(txtConvertFrom.getText());
    			double pounds = kilograms / 0.45359237;
    			txtConvertTo.setText("" + pounds);
    		}
    		
    		else if (ddConvertFrom.getSelectionModel().getSelectedItem().equals("Kilograms (kg)") && ddConvertTo.getSelectionModel().getSelectedItem().equals("Ounces (oz)")) {
    			double kilograms = Double.parseDouble(txtConvertFrom.getText());
    			double ounces = kilograms * 35.274;
    			txtConvertTo.setText("" + ounces);
    		}
    		
    		
    		else if (ddConvertFrom.getSelectionModel().getSelectedItem().equals("Kilograms (kg)") && ddConvertTo.getSelectionModel().getSelectedItem().equals("Grams (g)")) {
    			double kilograms = Double.parseDouble(txtConvertFrom.getText());
    			double grams = kilograms * 1000;
    			txtConvertTo.setText("" + grams);
    		}
    		
    		
    		else if (ddConvertFrom.getSelectionModel().getSelectedItem().equals("Ounces (oz)") && ddConvertTo.getSelectionModel().getSelectedItem().equals("Kilograms (kg)")) {
    			double ounces = Double.parseDouble(txtConvertFrom.getText());
    			double kilograms = ounces / 35.274;
    			txtConvertTo.setText("" + kilograms);
    		}
    		
    		else if (ddConvertFrom.getSelectionModel().getSelectedItem().equals("Ounces (oz)") && ddConvertTo.getSelectionModel().getSelectedItem().equals("Pounds (lbs)")) {
    			double ounces = Double.parseDouble(txtConvertFrom.getText());
    			double pounds = ounces / 16;
    			txtConvertTo.setText("" + pounds);
    		}
    		
    		else if (ddConvertFrom.getSelectionModel().getSelectedItem().equals("Ounces (oz)") && ddConvertTo.getSelectionModel().getSelectedItem().equals("Grams (g)")) {
    			double ounces = Double.parseDouble(txtConvertFrom.getText());
    			double grams = ounces * 28.35;
    			txtConvertTo.setText("" + grams);
    		}
    		
    		else if (ddConvertFrom.getSelectionModel().getSelectedItem().equals("Grams (g)") && ddConvertTo.getSelectionModel().getSelectedItem().equals("Pounds (lbs)")) {
    			double grams = Double.parseDouble(txtConvertFrom.getText());
    			double pounds = grams / 454;
    			txtConvertTo.setText("" + pounds);
    		}
    		
    		else if (ddConvertFrom.getSelectionModel().getSelectedItem().equals("Grams (g)") && ddConvertTo.getSelectionModel().getSelectedItem().equals("Kilograms (kg)")) {
    			double grams = Double.parseDouble(txtConvertFrom.getText());
    			double kilograms = grams / 1000;
    			txtConvertTo.setText("" + kilograms);
    		}
    		
    		
    		else if (ddConvertFrom.getSelectionModel().getSelectedItem().equals("Grams (g)") && ddConvertTo.getSelectionModel().getSelectedItem().equals("Ounces (oz)")) {
    			double grams = Double.parseDouble(txtConvertFrom.getText());
    			double ounces = grams / 28.35;
    			txtConvertTo.setText("" + ounces);
    		}
    		
    	}
    	
    	
    	
    	
    }
    

}
