package pl.jharmony.string.calculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberIteratorTest {

	@Test
	public void testPositiveNumbers() throws Exception {
		NumberIterator iterator = new NumberIterator("123");
		assertTrue(iterator.hasNext());
		assertEquals("123", iterator.next());
	}
	
	@Test
	public void testManyPositiveNumbers() throws Exception {
		NumberIterator iterator = new NumberIterator("123b45");
		assertTrue(iterator.hasNext());
		assertEquals("123", iterator.next());
		assertEquals("45", iterator.next());
	}
	
}
