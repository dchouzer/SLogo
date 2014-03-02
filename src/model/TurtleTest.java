package model;

import static org.junit.Assert.*;

/*
 * @author David Chou
 */

import org.junit.Test;

public class TurtleTest {

	@Test
	public void testMathTrig() {
		assertEquals(30.0, 30 * Math.sin(Math.toRadians(90)), 0.001);
	}
	
	@Test
	public void testMove() {
		Turtle turtle = new Turtle(0.0, 0.0, 1.0, null);
		turtle.moveForward(30.0);
		assertEquals(30.0, 0, 0.001);
	}

}
