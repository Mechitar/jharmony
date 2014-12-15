package pl.jharmony.string.calculator;

import java.util.List;

public class Calculator {

	public int add(String inputText)  {
		List<Integer> numbers = new StringUtil().convert(inputText).toCollectionOfNumbers();
		return new StringCalculator().rejectNegatives().skipBiggerThan(1000).sumOf(numbers);
	}
}
