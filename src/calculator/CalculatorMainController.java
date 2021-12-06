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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CalculatorMainController implements Initializable {
	private static boolean started = false;
	private static String selectedOperator = "";

	private static String Operand = "";
	private static float Result = 0;
	private static float tempResult = 0;

	@FXML
	private GridPane MyCalculatorMain;

	@FXML
	private TextField display;

	@FXML
	private TextField displayResult;

	@Override
	public void initialize(URL url, ResourceBundle rb) {

	}

	@FXML
	public void handleOnCrossButtonClicked(ActionEvent event) {
		if (Operand.length() > 0) {
			Operand = Operand.substring(0, Operand.length() - 1);
			if (Operand.length() == 0 && started == false) {
				Operand = "0";
			}
		}
		String temp = display.getText();

		if (temp.length() > 0 && !temp.equals("0")) {
			//char tempLastval = temp.charAt(temp.length() - 1);
			display.setText(temp.substring(0, temp.length() - 1));
			try {
				if(display.getText().charAt(display.getText().length()-2) == '('){
					temp = display.getText();
					display.setText(temp.substring(0, temp.length() - 2));
				}
			}
			catch(Exception e){
				
			}
			if (display.getText().length() == 0) {
				display.setText("0");
				started = false;
			}
		}
		calculateWholeResult();

	}

	@FXML
	public void handleOnMenu1ButtonClicked(ActionEvent event) {
		Stage stage = (Stage) MyCalculatorMain.getScene().getWindow();
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
	public void handleOnMenu2ButtonClicked(ActionEvent event) {
		Stage stage = (Stage) MyCalculatorMain.getScene().getWindow();
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
	public void handleOnRefreshClicked(ActionEvent event) {

		Stage stage = (Stage) MyCalculatorMain.getScene().getWindow();
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
	public void handleOnButtonClicked(ActionEvent event) {
		
		// System.out.println("Operand: "+Operand);
		Button button = (Button) event.getSource();
		String buttonText = button.getText();
//		System.out.println(buttonText);
		if (buttonText.equals("AC")) {

			display.setText("0");
			displayResult.setText("");
			started = false;
			Operand = "";
			Result = 0;
			tempResult=0;
			selectedOperator = "";
		} else if (started == false) {

			if (!(buttonText.equals("+")) && !(buttonText.equals("-"))
					&& !(buttonText.equals("X")) && !(buttonText.equals("/")) && !(buttonText.equals("="))
					&& !(buttonText.equals("%"))) {
				started = true;
				if (buttonText.equals(".")) {
					Operand = "0.";
					display.setText("0.");
				} else if (buttonText.equals("+/-")) {

					Operand = "-";
					display.setText("-");
				} else {
					Operand = buttonText;
					display.setText(buttonText);
				}
				displayResult.setText("");

			}

		} else if (buttonText.equals("=")) {
			if (Operand.length() > 0 && !Operand.equals("+") && !Operand.equals("-")) {
				calculateResult(buttonText);
				display.setText(String.valueOf(Result));
				Operand = String.valueOf(Result);
				Result = 0;
				displayResult.setText("");
			}

		} else if (buttonText.equals("+/-")) {
			if (Operand.length() > 0) {
				if (Operand.charAt(0) == '+') {
					char[] OperandChars = Operand.toCharArray();
					OperandChars[0] = '-';
					Operand = String.valueOf(OperandChars);
				} else if (Operand.charAt(0) == '-') {
					char[] OperandChars = Operand.toCharArray();
					OperandChars[0] = '+';
					Operand = String.valueOf(OperandChars);
				} else {
					Operand = "-" + Operand;
				}
				String temp = display.getText();
				int reqIndex = -1;
				for (int i = 0; i < temp.length() && selectedOperator.length() > 0; i++) {
					if (temp.charAt(i) == selectedOperator.charAt(0) && temp.charAt(i - 1) != '(') {
						reqIndex = i;
					}
				}
				display.setText(temp.substring(0, reqIndex + 1) + "(" + Operand);
				calculateTempResult();
				if (!(selectedOperator.equals("=")) && !(selectedOperator.equals("")))
					displayResult.setText("=" + String.valueOf(tempResult));

			} else {
				Operand = "-";
				display.setText(display.getText() + "(" + Operand);
			}

		} else {

			if (buttonText.matches("[0-9]") && !selectedOperator.equals("%")) {

				Operand += buttonText;
				calculateTempResult();
				if (!(selectedOperator.equals("=")) && !(selectedOperator.equals("")))
					displayResult.setText("=" + String.valueOf(tempResult));

				display.setText(display.getText() + buttonText);

			} else if (buttonText.equals(".")) {
				if (!(Operand.length() > 0)) {
					Operand += "0.";
					display.setText(display.getText() + "0.");

				} else if (Operand.contains(".")) {

				} else {
					Operand += buttonText;
					calculateTempResult();
					if (!(selectedOperator.equals("=")) && !(selectedOperator.equals("")))
						displayResult.setText("=" + String.valueOf(tempResult));
					display.setText(display.getText() + buttonText);
				}

			}

			if (Operand.length() > 0) {

				if (buttonText.equals("+") || buttonText.equals("-") || buttonText.equals("X") || buttonText.equals("/")
						|| buttonText.equals("%")) {
					calculateResult(buttonText);
					display.setText(display.getText() + buttonText);
					displayResult.setText("");
					if (buttonText.equals("%")) {
						calculateTempResult();
						if (!(selectedOperator.equals("=")) && !(selectedOperator.equals("")))
							displayResult.setText("=" + String.valueOf(tempResult));
					}
				}

			}

		}

		// System.out.println("Operand: "+Operand);
		//System.out.println("Now Result: " + tempResult);
	}

	public void calculateResult(String operator) {

		if (operator.equals("%")) {
			if (selectedOperator.equals("X")) {
				Result = Result * Float.parseFloat(Operand);
				Result = Result / 100;
			} else if (selectedOperator.equals("/")) {
				Result = Result / Float.parseFloat(Operand);
				Result = Result * 100;
			} else if (selectedOperator.equals("+")) {
				float temp = Result * (Float.parseFloat(Operand) / 100);
				Result = Result + temp;
				;
			} else if (selectedOperator.equals("-")) {
				float temp = Result * (Float.parseFloat(Operand) / 100);
				Result = Result - temp;
				;
			} else {
				Result = Float.parseFloat(Operand);
				Result = Result / 100;
			}
			Operand = String.valueOf(Result);
			selectedOperator = "%";
			return;
		}
		if (selectedOperator.equals("+")) {
			Result = Result + Float.parseFloat(Operand);
		} else if (selectedOperator.equals("-")) {
			Result = Result - Float.parseFloat(Operand);
		} else if (selectedOperator.equals("X")) {
			Result = Result * Float.parseFloat(Operand);
		} else if (selectedOperator.equals("/")) {
			Result = Result / Float.parseFloat(Operand);
		} else {
			if(!(Operand.equals(""))){
				Result = Float.parseFloat(Operand);
			}
			
		}
//		System.out.println("Operator: "+selectedOperator);
//		 System.out.println("Operand: "+Operand);
//		 System.out.println("Result: "+Result);

		selectedOperator = operator;
		Operand = "";

	}

	public void calculateTempResult() {
		if (Operand.equals("")) {
			tempResult = Result;
			return;
		} else if (selectedOperator.equals("+")) {
			try {
				tempResult = Result + Float.parseFloat(Operand);
			}
			catch(Exception e) {
				
			}
			
		} else if (selectedOperator.equals("-")) {
			try {
				tempResult = Result - Float.parseFloat(Operand);
			}
			catch(Exception e) {
				
			}
		} else if (selectedOperator.equals("X")) {
			try {
				tempResult = Result * Float.parseFloat(Operand);
			}
			catch(Exception e) {
				
			}
		} else if (selectedOperator.equals("/")) {
			try {
				tempResult = Result / Float.parseFloat(Operand);
			}
			catch(Exception e) {
				
			}
		} else if (selectedOperator.equals("%")) {
			tempResult = Result;
		} else {
			try {
				tempResult = Float.parseFloat(Operand);
			}
			catch(Exception e) {
				
			}
		}
	}

	public void calculateWholeResult() {

		String tempString = display.getText();
		selectedOperator="";
		int previndex=-1;
		
		for (int i = 0; i < tempString.length(); i++) {
			//System.out.println(i+" "+tempString.charAt(i));
			if ((tempString.charAt(i) == '+' || tempString.charAt(i) == '-' || tempString.charAt(i) == 'X'
					|| tempString.charAt(i) == '/' || tempString.charAt(i) == '%') && tempString.charAt(i-1) != '(' ) {
				Operand=tempString.substring(previndex+1, i);
				//System.out.println(Operand);
				calculateResult(tempString.charAt(i)+"");
				previndex=i;
			
			}
			
			
		}
		try {
			if(!tempString.endsWith("%")) {
				
				Operand=tempString.substring(previndex+1, tempString.length());
				if(Operand.charAt(0)=='(') {
					Operand=Operand.substring(1, Operand.length());
				}
				if(Operand.endsWith("+") || Operand.endsWith("-")) {
					Operand="";
				}
				System.out.println(Operand);
			}
			
		}
		catch(Exception e){
			Operand="";
		}
		

		calculateTempResult();
		if (!(selectedOperator.equals("=")) && !(selectedOperator.equals("")) && !(Operand.equals("")))
			displayResult.setText("=" + String.valueOf(tempResult));
		else {
			displayResult.setText("");
		}
	}

}
