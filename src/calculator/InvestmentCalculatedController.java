package calculator;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class InvestmentCalculatedController {
	
	  @FXML
	    private GridPane MyInvestmentCalculated;

	  @FXML
	    private Label investmentText;
	  
	  @FXML
	    private ProgressBar percenProgress;

    public void initData(String investment, String interest, String duration) {

    	double investmentAmount = Double.parseDouble(investment);
		int years = Integer.parseInt(duration);
		double InterestRate = Double.parseDouble(interest);
		
		double result= Math.pow((1 + ((InterestRate/100)/4)), years*4);
		result*=investmentAmount;
    	
		
    	
    	investmentText.setText(duration+" Years"+"\n\n"+String.format("Rs.%.2f",result));
    	
    	
    	
    	double progress=Double.parseDouble(investment)/result;
    	
    	System.out.println(progress);
    	
    	percenProgress.setProgress(progress);
       	
    }
    
    @FXML
	public void handleOnBackButton(MouseEvent event) {
		Stage stage= (Stage) MyInvestmentCalculated.getScene().getWindow();
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
