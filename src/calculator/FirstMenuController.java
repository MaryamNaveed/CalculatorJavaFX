package calculator;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FirstMenuController implements Initializable {


	@FXML
    private GridPane MyFirstMenu;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
	}
	
	@FXML
	public void handleOnMainCalculatorButtonClicked(ActionEvent event) {
		 	
		
		Stage stage = (Stage) MyFirstMenu.getScene().getWindow();
	    stage.close();
			try {
				
				Parent root = FXMLLoader.load(getClass().getResource("CalculatorMain.fxml"));
		        stage.setTitle("Calculator");
		        stage.setScene(new Scene(root, 500, 600));
		        stage.show();
		        
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 	
		
	}
	
	@FXML
	public void handleOnImageBMIClicked(MouseEvent event) {
		 	
		
		Stage stage = (Stage) MyFirstMenu.getScene().getWindow();
	    stage.close();
			try {
				
				Parent root = FXMLLoader.load(getClass().getResource("BMI.fxml"));
		        stage.setTitle("Calculator");
		        stage.setScene(new Scene(root, 500, 600));
		        stage.show();
		        
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 	
		
	}
	
	@FXML
	public void handleOnMenu2ButtonClicked(ActionEvent event) {
		Stage stage = (Stage) MyFirstMenu.getScene().getWindow();
		stage.close();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("SecondMenu.fxml"));
			stage.setTitle("Calculator");
			stage.setScene(new Scene(root, 500, 600));
			stage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@FXML
	public void handleOnImageDiscountClicked(MouseEvent event) {
		Stage stage = (Stage) MyFirstMenu.getScene().getWindow();
		stage.close();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Discount.fxml"));
			stage.setTitle("Calculator");
			stage.setScene(new Scene(root, 500, 600));
			stage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@FXML
	public void handleOnImageAgeClicked(MouseEvent event) {
		Stage stage = (Stage) MyFirstMenu.getScene().getWindow();
		stage.close();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Age.fxml"));
			stage.setTitle("Calculator");
			stage.setScene(new Scene(root, 500, 600));
			stage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}




	
	