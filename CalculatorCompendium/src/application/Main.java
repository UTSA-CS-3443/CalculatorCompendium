/**
 * Main class of the application, which launches it.
 * 
 * @author Estela V. Rodriguez-Greenfield (wgi663)
 *
 */

package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	
public static Stage stage;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			AnchorPane root = new AnchorPane();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation( Main.class.getResource("view/Main.fxml"));
			root = (AnchorPane) loader.load();
							
			Scene scene = new Scene( root );
			
			primaryStage.setScene( scene );
			primaryStage.setTitle("Calculator Compendium");
			primaryStage.show();
			
			stage = primaryStage;
	
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
