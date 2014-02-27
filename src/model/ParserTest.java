package model;

import static org.junit.Assert.*;

import org.junit.Test;
import commandcontrol.*;
public class ParserTest {

	@Test
	public void arrayInstantiation() throws Exception {
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
	public void cursorInstantiation() throws Exception {
		Parser p = new Parser();
		String s = "fd 50";
		p.parseProgram(s);
		String[] array = {"fd", "50"};
		assertEquals(p.cursor, -1);
	}
	
	public void testParseExecution() throws Exception {
		NumberCommand num = new NumberCommand(50.0);
		ForwardCommand fd = new ForwardCommand(num);
		Parser p = new Parser();
		String s = "fd 50";
		p.parseProgram(s);
	}
	
	
}
