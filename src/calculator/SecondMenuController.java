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

public class SecondMenuController implements Initializable {


	@FXML
    private GridPane MySecondMenu;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
	}
	
	@FXML
	public void handleOnMainCalculatorButtonClicked(ActionEvent event) {
		 	
		Stage stage = (Stage) MySecondMenu.getScene().getWindow();
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
	public void handleOnMenu1ButtonClicked(ActionEvent event) {
		Stage stage = (Stage) MySecondMenu.getScene().getWindow();
		stage.close();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("FirstMenu.fxml"));
			stage.setTitle("Calculator");
			stage.setScene(new Scene(root, 500, 600));
			stage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@FXML
	public void handleOnCurrencyImageClicked(MouseEvent event) {
		Stage stage = (Stage) MySecondMenu.getScene().getWindow();
		stage.close();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("CurrencyConverter.fxml"));
			stage.setTitle("Calculator");
			stage.setScene(new Scene(root, 500, 600));
			stage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@FXML
	public void handleOnInvestmentImageClicked(MouseEvent event) {
		Stage stage = (Stage) MySecondMenu.getScene().getWindow();
		stage.close();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("InvestmentCalculator.fxml"));
			stage.setTitle("Calculator");
			stage.setScene(new Scene(root, 500, 600));
			stage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
