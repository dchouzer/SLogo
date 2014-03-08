package main;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * @author David Chou
 */

public class ErrorTest {

	@Test
	public void testBracketCountChecker() {
		ErrorChecker ec = new ErrorChecker();
		String testOne = "[[[]]";
		String testTwo = "[[[[]]]]";
		String testThree = "[ca fd][c][";
		assertEquals(ec.bracketCountChecker(testOne), false);
		assertEquals(ec.bracketCountChecker(testTwo), true);
		assertEquals(ec.bracketCountChecker(testThree), false);
		
	}
	@Test
	public void testBracketLeftBeforeRight() {
		ErrorChecker ec = new ErrorChecker();
		String testOne = "[]]]";
		String testTwo = "][]]]]";
		String testThree = "[ca fd][c][";
		assertEquals(ec.bracketLeftBeforeRight(testOne), false);
		assertEquals(ec.bracketLeftBeforeRight(testTwo), false);
		assertEquals(ec.bracketLeftBeforeRight(testThree), true);
	}

}
