package calculator;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import java.util.ResourceBundle;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AgeController  implements Initializable {


    @FXML
    private GridPane MyAge;

	 @FXML
	    private DatePicker birthDate;

    @FXML
    private DatePicker currentDate;
    
    @FXML
    private Label AgeArea;


    @FXML
    private Label NextBirthDay;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		birthDate.setValue(LocalDate.now());
		
	
		currentDate.setValue(LocalDate.now());
		
		NextBirthDay.setText(LocalDate.now().plusYears(1).toString());
		
		
	}
	
	@FXML
	public void calculateAge() {
		LocalDate bdate = birthDate.getValue();
		
		LocalDate cdate = currentDate.getValue();
		
		
		
		long years=ChronoUnit.YEARS.between(bdate, cdate);
		
		Period period = Period.between(bdate, cdate);
		
		
		
		//System.out.print(years);
		
		AgeArea.setText(String.valueOf(period.getYears())+" Years " + String.valueOf(period.getMonths())+"  Months "+ String.valueOf(period.getDays())+" Days ");
		
		LocalDate nextbday=bdate.plusYears(years+1);
		
		
		NextBirthDay.setText(nextbday.toString());
		
		
		
		
		
		
	}
	
	 @FXML
	    void HandleOnBackButton(MouseEvent event) {
	    	
	    	Stage stage = (Stage) MyAge.getScene().getWindow();
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
}
