package calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Discount extends Application {
	
	       
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Discount.fxml"));
        stage.setTitle("Calculator");
        stage.setScene(new Scene(root, 500, 600));
        stage.show();
        
    }
    
}