package pl.jharmony.string.calculator;

import java.util.List;

public class NegativesNotAllowed extends RuntimeException {
	
	/**
	 */
	private static final long serialVersionUID = 1L;

	public NegativesNotAllowed(List<Integer> allNegatives) {
		super("Negatives not allowed " + allNegatives);
	}
}
