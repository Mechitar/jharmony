package pl.jharmony.string.calculator;

import java.util.StringTokenizer;

public class StringCalculator {

	private String input;
	
	private String numbers;

	private String commaDelimitedNumbers;
	
	public StringCalculator of(String inputText) {
		this.input= inputText;
		return this;
	}

	public StringCalculator replaceAllNewLines() {
		numbers.replace(Delimiter.NEW_LINE, Delimiter.COMMA);
		return this;
	}


	private void justSkipExceptions(NumberFormatException ex) {
		System.out.println("Oops! Definetely this was not a number. Sorry, the parser failed because of: " + ex);
	}

	public int andCalculateSum() {
		int sum = 0;
		StringTokenizer tokenizerToFindNumbers = new StringTokenizer(commaDelimitedNumbers, Delimiter.COMMA);
		while (tokenizerToFindNumbers.hasMoreElements()) {
			try {
				sum += Integer.parseInt(tokenizerToFindNumbers.nextToken());
			} catch (NumberFormatException ex) {
				justSkipExceptions(ex);
			}
		}
		return sum;
	}

}
