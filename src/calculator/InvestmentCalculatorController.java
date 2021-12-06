package calculator;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import javafx.stage.Stage;

public class InvestmentCalculatorController {
	
	  @FXML
	    private GridPane MyInvestmentCalculator;

	    @FXML
	    private TextField investmentAmount;

	    @FXML
	    private TextField Interest;

	    @FXML
	    private TextField durationInYears;
	
	@FXML
	  void HandleOnBackButton(MouseEvent event) {

		Stage stage = (Stage) MyInvestmentCalculator.getScene().getWindow();
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
	  void HandleOnCalculateButton(MouseEvent event) {
		if(isDouble(investmentAmount.getText()) && isDouble(Interest.getText()) && isInt(durationInYears.getText())) {
			Stage stage = (Stage) MyInvestmentCalculator.getScene().getWindow();
			stage.close();
			
			try {
				
				FXMLLoader loader=new FXMLLoader();
				loader.setLocation(getClass().getResource("InvestmentCalculated.fxml"));
				
				Parent root = loader.load();
				stage.setTitle("Calculator");
				
				stage.setScene(new Scene(root, 500, 600));		
				
				InvestmentCalculatedController controller=loader.getController();
				controller.initData(investmentAmount.getText(), Interest.getText(), durationInYears.getText());
				
				stage.show();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		else {
			if(!isDouble(investmentAmount.getText()) ) {
				Alert a = new Alert(AlertType.NONE);
				
				 a.setAlertType(AlertType.WARNING);
				 
				 a.setHeaderText("Incorrect Investment Amount...Enter positive numeric value");
				
				              
				  a.show();
				     

				
			}
			else if(!isDouble(Interest.getText())) { 
				Alert a = new Alert(AlertType.NONE);
				
				 a.setAlertType(AlertType.WARNING);
				 
				 a.setHeaderText("Incorrect Interest value...Enter positive numeric value");
				
				              
				  a.show();
				
			}
			else if(!isInt(durationInYears.getText())){
				Alert a = new Alert(AlertType.NONE);
				
				 a.setAlertType(AlertType.WARNING);
				 
				 a.setHeaderText("Incorrect number of years...Enter positive numeric value");
				
				              
				  a.show();
			}
		}
		
		
		
	
	}
	
	private static boolean isDouble(String str) {
        try {
            double d = Double.parseDouble(str);
            if(d<0) {
            	return false;
            }
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
	
	private static boolean isInt(String str) {
        try {
           int d=Integer.parseInt(str);
           if(d<0) {
           	return false;
           }
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}
