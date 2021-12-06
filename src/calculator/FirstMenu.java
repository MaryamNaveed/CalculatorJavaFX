package calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FirstMenu  extends Application {
	
	       
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FirstMenu.fxml"));
        stage.setTitle("Calculator");
        stage.setScene(new Scene(root, 500, 600));
        stage.show();
        
    }
    
}