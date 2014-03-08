package main;

/*
 * @author David Chou
 * @author Jeremiah Siochi
 */

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import command.Command;
public class ParserTest {
	
	@Test
	public void testParse() throws Exception {
		Parser p = new Parser();
		String s = "fd 50";
		String[] array1 = {"fd", "50"};
		assertArrayEquals(array1, array1);
	}

	@Test
	public void arrayInstantiationParseProgram() throws Exception {
		//Test very first case
		Parser p = new Parser();
		String s = "fd fd sum 50 50";
		p.parseProgram(s);
		String[] array1 = {"fd", "fd", "sum", "50", "50"};
		assertArrayEquals(array1, array1);
		
		//Account for extra spaces
		Parser pa = new Parser();
		String s1 = "fd   fd  sum 50   50  rt    50";
		pa.parseProgram(s1);
		String[] array2 = {"fd", "fd", "sum", "50", "50", "rt", "50"};
		assertArrayEquals(array2, array2);
	}

	@Test
	public void cursorInstantiationParseProgram() throws Exception {
		Parser p = new Parser();
		String s = "fd 50";
		p.parseProgram(s);
		assertEquals(2, 2);
	}
	
	@Test
	public void testParseExecution() throws Exception {
		Parser p = new Parser();
		String s = "fd fd sum sum fd 20 rt 100 50";
		double actual = p.parseProgram(s).get(0).execute();
		assertEquals(170.0, actual, 0.01);
	}
	
	@Test
	public void testLoopParse() throws Exception {
		Parser p = new Parser();
		String s = "repeat 6 [ fd rt 35 ] ";
		List<Command> commandList = p.parseProgram(s);
		assertEquals(35.0, commandList.get(0).execute(), 0.01);
	}
	
	@Test
	public void testNestedLoopParse() throws Exception {
		Parser p = new Parser();
		String s = "repeat 6 [ fd rt 35 repeat 4 [ fd 50 ] ] fd 20";
		List<Command> commandList = p.parseProgram(s);
		assertEquals(20.0, commandList.get(1).execute(), 0.01);
		assertEquals(50.0, commandList.get(0).execute(), 0.01);
	}
	
}
