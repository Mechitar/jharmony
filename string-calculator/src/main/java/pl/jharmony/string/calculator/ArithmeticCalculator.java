package pl.jharmony.string.calculator;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator {


	private Integer limit; 

	private boolean rejectNegatives = false;
	
	private List<Integer> allNegatives = new ArrayList<Integer>();
	

	public int sumOf(List<Integer> numbers) {
		int sum = 0;
		for (Integer number : numbers) {
				if (rejectNegatives && number < 0){
					allNegatives.add(number);
					number = 0;
				}
				if (hasDefinedCustomLimit() && isGreaterThanLimit(number)) {
					number = 0;
				}
				sum += number;
		}
		if (!allNegatives.isEmpty()) {
			throw new NegativesNotAllowed(allNegatives);
		}
		return sum;
	}

	
	private boolean isGreaterThanLimit(Integer number) {
		return number > limit;
	}

	private boolean hasDefinedCustomLimit() {
		return limit != null;
	}

	
	public ArithmeticCalculator skipBiggerThan(int limit) {
		this.limit = limit;
		return this;
	}


	public ArithmeticCalculator rejectNegatives() {
		this.rejectNegatives = true;
		return this;
	}
	
}
