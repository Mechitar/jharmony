package pl.jharmony.string.calculator;

import java.util.Iterator;

public class NumberIterator implements Iterator<String> {

	private String inputText;
	int currentIndex = 0;
	
	public NumberIterator(String inputText) {
		this.inputText = inputText;
	}

	public boolean hasNext() {
		int lastDigit = currentIndex;
		for ( int i = 0 ; i< inputText.length(); i++){
			if (Character.isDigit(inputText.charAt(i))) {
				lastDigit = i;
			}
		}
		return lastDigit > currentIndex;
	}

	public String next() {
		int lastIndex = currentIndex;
		for (int i =currentIndex + 1; i < inputText.length(); i++) {
			if (Character.isDigit(inputText.charAt(i))) {
				lastIndex = i;
			}
			
		}
		
		return inputText.substring(currentIndex, lastIndex + 1);
	}
}
