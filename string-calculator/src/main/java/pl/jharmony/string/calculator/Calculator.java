package pl.jharmony.string.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Calculator {

	private List<Integer> allNegatives = new ArrayList<Integer>();
	
	public int add(String inputText)  {
		List<String> delimiters = getAppliedDelimiter(inputText);
		String numbers = extractNumbers(inputText);
		onlyNumbers(numbers);
		String delimitedNumbers = numbers.replace(Delimiter.NEW_LINE, Delimiter.COMMA);
		String commaDelimitedNumbers = replaceDelimitersWithComma(delimiters, delimitedNumbers);
		return calculateSumOf(commaDelimitedNumbers);
	}


	private int onlyNumbers(String inputText) {
		checkNegativesExistance(inputText);
		String commaAndNumbers = inputText.replaceAll("\\D", Delimiter.COMMA);
		return calculateSumOf(commaAndNumbers);
	}

	private void checkNegativesExistance(String inputText) {
		if (hasNegatives(inputText) ) {
			findAllNegatives(inputText);
			throw new NegativesNotAllowed(allNegatives);
		}
	}

	private boolean hasNegatives(String inputText) {
	StringTokenizer tokenizer = new StringTokenizer(inputText, "-");
	while(tokenizer.hasMoreTokens()) {
		System.out.println("negatives=" + tokenizer.nextToken());
		
	}
	return !allNegatives.isEmpty();
	}

	private void findAllNegatives(String inputText) {
		
	}

	private String replaceDelimitersWithComma(List<String> delimiters,
			String delimitedNumbers) {
		String commaDelimitedNumbers = new String(delimitedNumbers);
		for (String delimiter : delimiters) {
			commaDelimitedNumbers = new String(delimitedNumbers.replaceAll(delimiter, Delimiter.COMMA));
		}
		return commaDelimitedNumbers;
	}

	private String extractNumbers(String inputText) {
		String numbers = inputText;
		if (hasDefinedCustomDelimiterIn(inputText)) {
			int indexOfNewLine = inputText.indexOf(Delimiter.NEW_LINE);
			numbers = inputText.substring(++indexOfNewLine);
		}
		return numbers;
	}

	private List<String> getAppliedDelimiter(String inputText) {
		List<String> allDelimiters = new ArrayList<String>();
		allDelimiters.add(Delimiter.COMMA);
		if (hasDefinedCustomDelimiterIn(inputText)) {
			int startIndex = inputText.indexOf(Delimiter.SLASH) + Delimiter.SLASH.length();
			int endIndex = inputText.indexOf(Delimiter.NEW_LINE);
			String definedDelimiters = inputText.substring(startIndex, endIndex);
			allDelimiters.addAll( Arrays.asList( definedDelimiters.split("[[\\w]]+")));
		}
		return allDelimiters;
	}

	private boolean hasDefinedCustomDelimiterIn(String inputText) {
		return inputText.indexOf(Delimiter.SLASH) == 0;
	}

	private int calculateSumOf(String commaDelimitedNumbers) {
		int sum = 0;
		StringTokenizer tokenizerToFindNumbers = new StringTokenizer(
				commaDelimitedNumbers, Delimiter.COMMA);
		while (tokenizerToFindNumbers.hasMoreElements()) {
			try {
				int number = readNextInteger(tokenizerToFindNumbers);
				sum += number;
			} catch (NumberFormatException ex) {
				justSkipExceptions(ex);
			}
		}
		if (!allNegatives.isEmpty()) {
			throw new NegativesNotAllowed(allNegatives);
		}
		return sum;
	}

	private int readNextInteger(StringTokenizer tokenizerToFindNumbers) {
		int number = Integer.parseInt(tokenizerToFindNumbers.nextToken());
		number = rejectNegatives(number);
		number = skipBiggerThanThousand(number);
		return number;
	}

	private int skipBiggerThanThousand(int number) {
		if (number > 1000) {
			number = 0;
		}
		return number;
	}

	private int rejectNegatives(int number) {
		if (number < 0) {
			allNegatives.add(number);
			number = 0;
		}
		return number;
	}

	private void justSkipExceptions(NumberFormatException ex) {
		System.out.println("Oops! Definetely this was not a number. Sorry, the parser failed because of: "
						+ ex);
	}

}
