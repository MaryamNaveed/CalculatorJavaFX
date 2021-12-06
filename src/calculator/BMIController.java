package calculator;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BMIController {

    @FXML
    private GridPane MyBMI;

    @FXML
    private TextField weight;

    @FXML
    private TextField height;
    
    boolean isSelectedWeight=true;
    boolean isSelectedHeight=false;

    @FXML
    void HandleOnAnyButton(ActionEvent event) {
    	Button button = (Button) event.getSource();
		String buttonText = button.getText();

		if (buttonText.equals("AC")) {
			weight.setText("0");
			height.setText("0");
			isSelectedWeight=true;
		   isSelectedHeight=false;

		}
		if (buttonText.matches("[0-9]") ) {

				if(isSelectedWeight) {
					if(weight.getText().equals("0")) {
						weight.setText(buttonText);
					}
					else{
						weight.setText(weight.getText()+buttonText);
					}
					
				}
				
				if(isSelectedHeight) {
					if(height.getText().equals("0")) {
						height.setText(buttonText);
					}
					else{
						height.setText(height.getText()+buttonText);
					}
				}
			

		} else if (buttonText.equals(".")) {
			if(isSelectedWeight) {
				if(!weight.getText().contains(".")) {
				
					weight.setText(weight.getText()+buttonText);
				}
				
			}
			
			if(isSelectedHeight) {
				if(!height.getText().contains(".")) {
					height.setText(height.getText()+buttonText);
				}
			}

		}
    }
    
    @FXML
    void HandleOnMouseOnWeightField(MouseEvent event) {
    	isSelectedWeight=true;
        isSelectedHeight=false;
    }
    
    @FXML
    void HandleOnMouseOnHeightField(MouseEvent event) {
    	
    	isSelectedWeight=false;
        isSelectedHeight=true;
    }

    @FXML
    void HandleOnBackButton(MouseEvent event) {
    	
    	Stage stage = (Stage) MyBMI.getScene().getWindow();
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
    void HandleOnCrossButton(ActionEvent event) {
    	if(isSelectedWeight) {
			if(weight.getText().equals("0")) {
				
			}
			else{
				if(weight.getText().length()==1) {
					weight.setText("0");
				}
				else {
					weight.setText(weight.getText().substring(0, weight.getText().length()-1));
				}
			}
			
		}
		
		if(isSelectedHeight) {
			if(height.getText().equals("0")) {
				
			}
			else{
				if(height.getText().length()==1) {
					height.setText("0");
				}
				else {
					height.setText(height.getText().substring(0, height.getText().length()-1));
				}
			}
		}
    }

    @FXML
    void HandleOnGoButton(ActionEvent event) {

    	Stage stage = (Stage) MyBMI.getScene().getWindow();
		stage.close();
		BMIInfo info= new BMIInfo(weight.getText(), height.getText());
		try {
			
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(getClass().getResource("BMICalculated.fxml"));
			
			Parent root = loader.load();
			stage.setTitle("Calculator");
			
			stage.setScene(new Scene(root, 500, 600));		
			
			BMICalculatedController controller=loader.getController();
			controller.initData(info);
			
			stage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
