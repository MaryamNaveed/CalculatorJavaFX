package calculator;

public class Currency {
	
	float amount;
	String type;
	
		
	public Currency() {
	}
	public Currency(float amount, String type) {
		this.amount = amount;
		this.type = type;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
