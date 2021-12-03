/**
 * TaxController controls the Tax Calculator view.
 * 
 * @author Estela V. Rodriguez-Greenfield (wgi663)
 * @author Don Ayesh Sondapperumaarachchi
 * 
 */

package application.controller;

import application.Main;
import application.model.taxCalc;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.text.DecimalFormat;

public class TaxController {
	
	private static final DecimalFormat df = new DecimalFormat("#.00");

	@FXML
	private ComboBox<String> ddLocation;

	@FXML
	private Button btnBack;

	@FXML
	private TextField txtHouseholdIncome;

	@FXML
	private TextField txtDeductions;

	@FXML
	private Button btnCalculate;

	@FXML
	private TextField txtIRA;

	@FXML
	private Button btnClear;

	@FXML
	private TextField txt401k;

	@FXML
	private TextField txtExceptions;

	@FXML
	private ComboBox<String> ddFilingStatus;

	@FXML
    private Label lblResult;
	
	@FXML
	void handleClear(ActionEvent event) {
		txtHouseholdIncome.setText("0");
		txt401k.setText("0");
		txtIRA.setText("0");
		txtDeductions.setText("0");
		txtExceptions.setText("0");
		ddLocation.setValue("TEXAS");
		ddFilingStatus.setValue("Single");
		lblResult.setText(null);
	}

	@FXML
	void handleCalculate(ActionEvent event) {
		
		if (txt401k.getText() == "") {txt401k.setText("0");}
		int householdIncome = Integer.parseInt(txtHouseholdIncome.getText());
		int cont401k = Integer.parseInt(txt401k.getText());
		int contIRA = Integer.parseInt(txtIRA.getText());
		int ded = Integer.parseInt(txtDeductions.getText());
		int numExcepts = Integer.parseInt(txtExceptions.getText());
		String location = ddLocation.getValue().toString();
		String filingStatus = ddFilingStatus.getValue();

		taxCalc evnt = new taxCalc(householdIncome, cont401k, contIRA, ded, numExcepts, filingStatus, location);
		evnt.loadFederalTaxes();
		evnt.loadStates("data/states.csv");
		evnt.loadTaxRates("data/stateTaxRatesMarried.csv", "Married");
		evnt.loadTaxRates("data/stateTaxRatesSingle.csv", "Single");
		evnt.loadLocalTaxes("data/avgLocalTaxRateByState.csv");
		lblResult.setText("Income Tax To Be Paid: $" + df.format(evnt.calcTaxes()));
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
