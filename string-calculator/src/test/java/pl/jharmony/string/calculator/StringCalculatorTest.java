package pl.jharmony.string.calculator;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {

	private StringCalculator calculator;

	@Before
	public void init() {
		calculator = new StringCalculator();
	}
	@Test
	public void sumOfEmptyStringIsZero() throws Exception {
		assertEquals(0, calculator.add(""));
	}
	
	@Test
	public void sumOfOneMunberIsJustTheNumber() throws Exception {
		assertEquals(1, calculator.add("1"));
	}
	
	@Test
	public void sumCommaSeparatedNumbers() throws Exception {
		assertEquals(3, calculator.add("1,2"));
	}
	
	@Test
	public void sumOfThreeNUmbers() throws Exception {
		assertEquals(6, calculator.add("1,2,3"));
	}

	@Test
	public void sumOfThreeNumberWithANewLineCharacters() throws Exception {
		assertEquals(6, calculator.add("1\n,2,3"));
	}
	
	@Test
	public void sumOfUnknownAmountOfNumbers() throws Exception {
		Random integersGenerator = new Random();
		int aNumber = 0;
		int numberOfNumbers= integersGenerator.nextInt(10);
		int expectedSum=0;
		List<String> randomNumbers = new ArrayList<String>();
		for( int i = 0 ; i < numberOfNumbers; i++) {
			aNumber = integersGenerator.nextInt(30);
			randomNumbers.add(String.valueOf(aNumber));
			expectedSum += aNumber;
		}
		String commaSeparatedNumbers = String.join(",", randomNumbers);
		int calculatedSum = calculator.add(commaSeparatedNumbers);
		System.out.println( "The sum of " + randomNumbers + " is " + calculatedSum);
		assertEquals(expectedSum, calculatedSum);
	}
	
	@Test
	public void useCustomDelimiter() throws Exception {
		assertEquals(3, calculator.add("//;\n1;2"));
	}
	
	@Test(expected = NegativesNotAllowed.class)
	public void skipNegativeNumbers() throws Exception {
		calculator.add("//;\n1;-2;3");
	}
	
	
	@Test(expected = NegativesNotAllowed.class)
	public void skipBigNegativeNumbers() throws Exception {
		calculator.add("//;\n1;-200;300");
	}
	@Test
	public void skipNumbersBiggerThanThousand() throws Exception {
		assertEquals(2, calculator.add("2,1001"));
	}
	
	@Test
	public void useDelimitersLongerThanOneCharacter() throws Exception {
		assertEquals(6, calculator.add("//[***]\n1***2***3"));
	}
	
	@Test
	public void allowMultipleDelimiters() throws Exception {
		assertEquals(6, calculator.add("//[*][%]\n1*2%3"));
	}
}
