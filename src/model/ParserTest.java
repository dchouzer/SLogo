package model;

import static org.junit.Assert.*;

import org.junit.Test;
public class ParserTest {
	
	@Test
	public void testParse() throws Exception {
		Parser p = new Parser();
		String s = "fd 50";
		p.parseProgram(s);
		String[] array1 = {"fd", "50"};
		assertArrayEquals(p.myStringArray, array1);
	}

	@Test
	public void arrayInstantiationParseProgram() throws Exception {
		//Test very first case
		Parser p = new Parser();
		String s = "fd fd sum 50 50";
		p.parseProgram(s);
		String[] array1 = {"fd", "fd", "sum", "50", "50"};
		assertArrayEquals(p.myStringArray, array1);
		
		//Account for extra spaces
		Parser pa = new Parser();
		String s1 = "fd   fd  sum 50   50  rt    50";
		pa.parseProgram(s1);
		String[] array2 = {"fd", "fd", "sum", "50", "50", "rt", "50"};
		assertArrayEquals(pa.myStringArray, array2);
	}

	@Test
	public void cursorInstantiationParseProgram() throws Exception {
		Parser p = new Parser();
		String s = "fd 50";
		p.parseProgram(s);
		assertEquals(p.cursor, 2);
	}
	
	@Test
	public void testParseExecution() throws Exception {
		Parser p = new Parser();
		String s = "fd fd sum sum fd 20 rt 100 50";
		p.parseProgram(s);
		double actual = p.myCommandList.get(0).execute();
		assertEquals(170.0, actual, 0.01);
	}
	
	
}
