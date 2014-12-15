package pl.jharmony.string.calculator;

import java.util.List;

public class StringCalculator {

	public int add(String inputText)  {
		List<Integer> numbers = new StringUtil().convert(inputText).toCollectionOfNumbers();
		return new ArithmeticCalculator().rejectNegatives().skipBiggerThan(1000).sumOf(numbers);
	}
	
	public static void main(String[] args) {
		new StringCalculator().add(args[0]);
	}
}
