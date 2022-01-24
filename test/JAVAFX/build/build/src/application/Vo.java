package application;

public class Vo{
	
	private String inputValue;

	public String getInputValue() {
		return inputValue;
	}

	public String setInputValue(String inputValue) {
		return this.inputValue = inputValue;
	}

	@Override
	public String toString() {
		return "Vo [inputValue=" + inputValue + ", getInputValue()=" + getInputValue() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	
}
