package calculator;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DiscountController {
	 @FXML
	    private GridPane MyDiscount;
	 
	 @FXML
	    private Label saved;

	    @FXML
	    private TextField OrigPrice;

	    @FXML
	    private TextField discount;

	    @FXML
	    private TextField finPrice;

    
    boolean isSelectedOrigPrice=true;
    boolean isSelecteddiscount=false;
    
    @FXML
    void HandleOnMouseOnPriceField() {
    	isSelectedOrigPrice=true;
    	isSelecteddiscount=false;
    }
    
    @FXML
    void HandleOnMouseOnDiscountField() {
    	
    	isSelectedOrigPrice=false;
    	isSelecteddiscount=true;
    }

    @FXML
    void HandleOnAnyButton(ActionEvent event) {
    	Button button = (Button) event.getSource();
		String buttonText = button.getText();

		if (buttonText.equals("AC")) {
			OrigPrice.setText("0");
			discount.setText("0");
			isSelectedOrigPrice=true;
		   isSelecteddiscount=false;

		}
		if (buttonText.matches("[0-9]") ) {

				if(isSelectedOrigPrice) {
					if(OrigPrice.getText().equals("0")) {
						OrigPrice.setText(buttonText);
					}
					else{
						OrigPrice.setText(OrigPrice.getText()+buttonText);
					}
					
				}
				
				if(isSelecteddiscount) {
					if(discount.getText().equals("0")) {
						discount.setText(buttonText);
					}
					else{
						discount.setText(discount.getText()+buttonText);
					}
				}
			

		} else if (buttonText.equals(".")) {
			if(isSelectedOrigPrice) {
				if(!OrigPrice.getText().contains(".")) {
				
					OrigPrice.setText(OrigPrice.getText()+buttonText);
				}
				
			}
			
			if(isSelecteddiscount) {
				if(!discount.getText().contains(".")) {
					discount.setText(discount.getText()+buttonText);
				}
			}

		}
		
		float resultDiscount=Float.parseFloat(OrigPrice.getText())-(Float.parseFloat(discount.getText())*Float.parseFloat(OrigPrice.getText())/100);
		finPrice.setText(String.valueOf(resultDiscount));
		
		float savedPrice=Float.parseFloat(OrigPrice.getText())-resultDiscount;
		saved.setText("You Saved "+String.valueOf(savedPrice));
		
    }
    
    @FXML
    void HandleOnMouseOnOrigPriceField(MouseEvent event) {
    	isSelectedOrigPrice=true;
        isSelecteddiscount=false;
    }
    
    @FXML
    void HandleOnMouseOndiscountField(MouseEvent event) {
    	
    	isSelectedOrigPrice=false;
        isSelecteddiscount=true;
    }

    @FXML
    void HandleOnBackButton(MouseEvent event) {
    	
    	Stage stage = (Stage) MyDiscount.getScene().getWindow();
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
    	if(isSelectedOrigPrice) {
			if(OrigPrice.getText().equals("0")) {
				
			}
			else{
				if(OrigPrice.getText().length()==1) {
					OrigPrice.setText("0");
				}
				else {
					OrigPrice.setText(OrigPrice.getText().substring(0, OrigPrice.getText().length()-1));
				}
			}
			
		}
		
		if(isSelecteddiscount) {
			if(discount.getText().equals("0")) {
				
			}
			else{
				if(discount.getText().length()==1) {
					discount.setText("0");
				}
				else {
					discount.setText(discount.getText().substring(0, discount.getText().length()-1));
				}
			}
		}
		
		float resultDiscount=Float.parseFloat(OrigPrice.getText())-(Float.parseFloat(discount.getText())*Float.parseFloat(OrigPrice.getText())/100);
		finPrice.setText(String.valueOf(resultDiscount));
		
		float savedPrice=Float.parseFloat(OrigPrice.getText())-resultDiscount;
		saved.setText("You Saved "+String.valueOf(savedPrice));
    }

   
}
