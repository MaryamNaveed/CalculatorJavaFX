package calculator;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CurrencyConverterController implements Initializable {
	
	ArrayList<Currency> currencies= new ArrayList<Currency>();
	
	@FXML
	private GridPane MyCurrencyConverter;

	@FXML
	private TextField inputAmount;

	@FXML
	private TextField outputAmount;
	
	  @FXML
	 private MenuButton inputAmountType;

	  @FXML
	    private MenuButton outputAmountType;
	  

	    @FXML
	    private TextField inputMenuField;

	    @FXML
	    private TextField outputMenuField;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		currencies.add(new Currency(1,"Rupee"));
		currencies.add(new Currency(Float.parseFloat("0.0057"),"Dollar"));
		currencies.add(new Currency(Float.parseFloat("0.0043"),"Pound"));
		currencies.add(new Currency(Float.parseFloat("0.0050"),"Euro"));
		currencies.add(new Currency(Float.parseFloat("0.64"),"Yen"));
		
		
	}
	
	

	

	@FXML
	void HandleOnAnyButton(ActionEvent event) {
		Button button = (Button) event.getSource();
		String buttonText = button.getText();

		if (buttonText.equals("AC")) {
			
			inputAmount.setText("0");
		
			outputAmount.setText("0");
			
			return;

		}
		if (buttonText.matches("[0-9]")) {
			if (inputAmount.getText().equals("0")) {
				inputAmount.setText(buttonText);
			} else {
				inputAmount.setText(inputAmount.getText() + buttonText);
			}

		} else if (buttonText.equals(".")) {

			if (!inputAmount.getText().contains(".")) {

				inputAmount.setText(inputAmount.getText() + buttonText);
			}
		}
		
		float result1=convertToRupees(Float.parseFloat(inputAmount.getText()),inputMenuField.getText());
		
		float result=convertFromRupees(result1,outputMenuField.getText());
		
		outputAmount.setText(String.valueOf(result));

	}
	
	public float convertToRupees(float amount,String type){
		float val=0;
		
		for(int i=0; i<currencies.size(); i++) {
			if(currencies.get(i).getType().equalsIgnoreCase(type)) {
				val=amount/currencies.get(i).getAmount();
				break;
			}
		}
		return val;
	}
	
	public float convertFromRupees(float amount,String type){
		float val=0;
		
		for(int i=0; i<currencies.size(); i++) {
			if(currencies.get(i).getType().equalsIgnoreCase(type)) {
				val=amount*currencies.get(i).getAmount();
				break;
			}
		}
		
		return val;
		
	}

	@FXML
	  void HandleOnBackButton(MouseEvent event) {

		Stage stage = (Stage) MyCurrencyConverter.getScene().getWindow();
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
	void HandleOnCrossButton(ActionEvent event) {

		if (inputAmount.getText().equals("0")) {

		} else {
			if (inputAmount.getText().length() == 1) {
				inputAmount.setText("0");
			} else {
				inputAmount.setText(inputAmount.getText().substring(0, inputAmount.getText().length() - 1));
			}
		}
		
	float result1=convertToRupees(Float.parseFloat(inputAmount.getText()),inputMenuField.getText());
		
		float result=convertFromRupees(result1,outputMenuField.getText());
		
		outputAmount.setText(String.valueOf(result));
	}
	

    @FXML
    void HandleonInputOption(ActionEvent event) {

    	MenuItem m= (MenuItem) event.getSource();
		String buttonText = m.getText();
		
		inputMenuField.setText(buttonText);
		
		float result1=convertToRupees(Float.parseFloat(inputAmount.getText()),inputMenuField.getText());
		
		float result=convertFromRupees(result1,outputMenuField.getText());
		
		outputAmount.setText(String.valueOf(result));
		
    }

    @FXML
    void HandleonOutputOption(ActionEvent event) {
    	MenuItem m= (MenuItem) event.getSource();
		String buttonText = m.getText();
		
		outputMenuField.setText(buttonText);
		
		float result1=convertToRupees(Float.parseFloat(inputAmount.getText()),inputMenuField.getText());
		
		float result=convertFromRupees(result1,outputMenuField.getText());
		
		outputAmount.setText(String.valueOf(result));

    }

}
