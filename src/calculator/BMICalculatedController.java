package calculator;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class BMICalculatedController {

    @FXML
    private GridPane MyBMICalculated;

    @FXML
    private TextField weight;

    @FXML
    private TextField height;

    @FXML
    private TextArea Result;
    
    
    
    public void initData(BMIInfo info) {
    	
    
    	weight.setText(info.getWeight());
    	height.setText(info.getHeight());
    	
    	float BMI=(Float.parseFloat(weight.getText())/(Float.parseFloat(height.getText())*Float.parseFloat(height.getText())))*10000;
    	
    	Result.setText(String.valueOf(BMI)+"   BMI");
    	
    	Result.setText(Result.getText()+"\n\n");
    	
    	if(BMI<18.5) {
    		Result.setText(Result.getText()+"Normal");
    	}
    	else if(BMI>=18.5 && BMI<=24.9) {
    		Result.setText(Result.getText()+"Normal");
    	}
    	else if(BMI>=30 && BMI<=29.9) {
    		Result.setText(Result.getText()+"OverWeight");
    	}
    	else {
    		Result.setText(Result.getText()+"Obese");
    	}
    	
    	
    }

    @FXML
    void HandleOnBackButton(MouseEvent event) {
    	Stage stage = (Stage) MyBMICalculated.getScene().getWindow();
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

}
