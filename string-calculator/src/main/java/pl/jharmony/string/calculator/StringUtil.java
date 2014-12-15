package pl.jharmony.string.calculator;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {

	private String textToConvert;
	private List<Integer> allNumbers;

	public StringUtil() {
		allNumbers = new ArrayList<Integer>();
	}

	public StringUtil convert(String text) {
		this.textToConvert = text;
		return this;
	}

	public List<Integer> toCollectionOfNumbers() {
		String[] numbers = findAllNumbers();
		for (String number : numbers) {
			if (isInteger(number)) {
				allNumbers.add(parseIntWithSign(number));
			}
		}
		return allNumbers;
	}

	protected boolean isInteger(String number) {
		return number.matches("[0-9]*");
	}

	protected int parseIntWithSign(String number) {
		int parseInt = parseInt(number);
		if (isNegative(number)) {
			parseInt *= -1;
		}
		return parseInt;
	}

	protected String[] findAllNumbers() {
		return textToConvert.split("\\D");
	}

	protected boolean isNegative(String number) {
		int indexOf = textToConvert.indexOf(number);
		String beforeTheNumber = textToConvert.substring(0, indexOf);
		return beforeTheNumber.endsWith("-");
	}

	protected int parseInt(String numberAsString) {
		int number = 0;
		try {
			number = Integer.parseInt(numberAsString);
		} catch (NumberFormatException ex) {
			justSkipExceptions(ex);
		}
		return number;
	}

	private void justSkipExceptions(NumberFormatException ex) {
		System.out.println("Oops! Definitely this was not a number." + ex);
	}

}
