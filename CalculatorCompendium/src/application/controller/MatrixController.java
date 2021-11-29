/**
 * MatrixController controls the Matrix Calculator view.
 * 
 * @author Estela V. Rodriguez-Greenfield (wgi663)
 */

package application.controller;

import application.Main;
import application.model.matrixAdd;
import application.model.matrixMultiply;
import application.model.matrixSubtract;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Arrays;

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
			int[][] matrixA = new int[3][3];
			int[][] matrixB = new int[3][3];
			matrixMultiply multiplyingMatrices = new matrixMultiply();
			//Matrix A
			matrixA[0][0] = Integer.parseInt(txtA11.getText());
			matrixA[0][1] = Integer.parseInt(txtA12.getText());
			matrixA[0][2] = Integer.parseInt(txtA13.getText());
			matrixA[1][0] = Integer.parseInt(txtA21.getText());
			matrixA[1][1] = Integer.parseInt(txtA22.getText());
			matrixA[1][2] = Integer.parseInt(txtA23.getText());
			matrixA[2][0] = Integer.parseInt(txtA31.getText());
			matrixA[2][1] = Integer.parseInt(txtA32.getText());
			matrixA[2][2] = Integer.parseInt(txtA33.getText());
			//Matrix B
			matrixB[0][0] = Integer.parseInt(txtB11.getText());
			matrixB[0][1] = Integer.parseInt(txtB12.getText());
			matrixB[0][2] = Integer.parseInt(txtB13.getText());
			matrixB[1][0] = Integer.parseInt(txtB21.getText());
			matrixB[1][1] = Integer.parseInt(txtB22.getText());
			matrixB[1][2] = Integer.parseInt(txtB23.getText());
			matrixB[2][0] = Integer.parseInt(txtB31.getText());
			matrixB[2][1] = Integer.parseInt(txtB32.getText());
			matrixB[2][2] = Integer.parseInt(txtB33.getText());
			//Test output for matrix in command line
			System.out.println("Matrix A : " + Arrays.deepToString(matrixA));
			System.out.println("Matrix B : " + Arrays.deepToString(matrixB));

			multiplyingMatrices.multiplyMatrix(matrixA, matrixB);
			txtResult.setText(multiplyingMatrices.toString());
	    }

	    @FXML
	    void handleAPlusB(ActionEvent event)  {
			//since are matrix size is a fixed 3x3 we need to be able to know our TRUE size.
			//I'll be filling in a 3x3 matrix that will be passed to a function in function "matrixDataHandler".
			//This function pass will be called through an object where all our data changes will be stored for
			//all matrix functions.
			int[][] matrixA = new int[3][3];
			int[][] matrixB = new int[3][3];
			matrixAdd addingMatrices = new matrixAdd();
			//Matrix A
			matrixA[0][0] = Integer.parseInt(txtA11.getText());
			matrixA[0][1] = Integer.parseInt(txtA12.getText());
			matrixA[0][2] = Integer.parseInt(txtA13.getText());
			matrixA[1][0] = Integer.parseInt(txtA21.getText());
			matrixA[1][1] = Integer.parseInt(txtA22.getText());
			matrixA[1][2] = Integer.parseInt(txtA23.getText());
			matrixA[2][0] = Integer.parseInt(txtA31.getText());
			matrixA[2][1] = Integer.parseInt(txtA32.getText());
			matrixA[2][2] = Integer.parseInt(txtA33.getText());
			//Matrix B
			matrixB[0][0] = Integer.parseInt(txtB11.getText());
			matrixB[0][1] = Integer.parseInt(txtB12.getText());
			matrixB[0][2] = Integer.parseInt(txtB13.getText());
			matrixB[1][0] = Integer.parseInt(txtB21.getText());
			matrixB[1][1] = Integer.parseInt(txtB22.getText());
			matrixB[1][2] = Integer.parseInt(txtB23.getText());
			matrixB[2][0] = Integer.parseInt(txtB31.getText());
			matrixB[2][1] = Integer.parseInt(txtB32.getText());
			matrixB[2][2] = Integer.parseInt(txtB33.getText());
			//Test output for matrix in command line
			System.out.println("Matrix A : " + Arrays.deepToString(matrixA));
			System.out.println("Matrix B : " + Arrays.deepToString(matrixB));

			addingMatrices.multiplyAdd(matrixA, matrixB);
			txtResult.setText(addingMatrices.toString());
		}

	    @FXML
	    void handleAMinusB(ActionEvent event) {
			int[][] matrixA = new int[3][3];
			int[][] matrixB = new int[3][3];
			matrixSubtract subtractingMatrices = new matrixSubtract();
			//Matrix A
			matrixA[0][0] = Integer.parseInt(txtA11.getText());
			matrixA[0][1] = Integer.parseInt(txtA12.getText());
			matrixA[0][2] = Integer.parseInt(txtA13.getText());
			matrixA[1][0] = Integer.parseInt(txtA21.getText());
			matrixA[1][1] = Integer.parseInt(txtA22.getText());
			matrixA[1][2] = Integer.parseInt(txtA23.getText());
			matrixA[2][0] = Integer.parseInt(txtA31.getText());
			matrixA[2][1] = Integer.parseInt(txtA32.getText());
			matrixA[2][2] = Integer.parseInt(txtA33.getText());
			//Matrix B
			matrixB[0][0] = Integer.parseInt(txtB11.getText());
			matrixB[0][1] = Integer.parseInt(txtB12.getText());
			matrixB[0][2] = Integer.parseInt(txtB13.getText());
			matrixB[1][0] = Integer.parseInt(txtB21.getText());
			matrixB[1][1] = Integer.parseInt(txtB22.getText());
			matrixB[1][2] = Integer.parseInt(txtB23.getText());
			matrixB[2][0] = Integer.parseInt(txtB31.getText());
			matrixB[2][1] = Integer.parseInt(txtB32.getText());
			matrixB[2][2] = Integer.parseInt(txtB33.getText());
			//Test output for matrix in command line
			System.out.println("Matrix A : " + Arrays.deepToString(matrixA));
			System.out.println("Matrix B : " + Arrays.deepToString(matrixB));

			subtractingMatrices.subtractMatrix(matrixA, matrixB);
			txtResult.setText(subtractingMatrices.toString());
	    }

	    @FXML
	    void handleClear(ActionEvent event) {
	    	//Clear results
			txtResult.setText("Result...");

			//Clear Matrix A
			txtA11.setText("0");
			txtA12.setText("0");
			txtA13.setText("0");
			txtA21.setText("0");
			txtA22.setText("0");
			txtA23.setText("0");
			txtA31.setText("0");
			txtA32.setText("0");
			txtA33.setText("0");

			//Clear Matrix B
			txtB11.setText("0");
			txtB12.setText("0");
			txtB13.setText("0");
			txtB21.setText("0");
			txtB22.setText("0");
			txtB23.setText("0");
			txtB31.setText("0");
			txtB32.setText("0");
			txtB33.setText("0");
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
