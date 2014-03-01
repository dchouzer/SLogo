package model;


import static org.junit.Assert.*;

import org.junit.Test;

public class TurtleTester {
	@SuppressWarnings("deprecation")
	@Test
	public void testMove() {
		Turtle turtle = new Turtle(30,0,0);
		turtle.moveForward(50.0);
		assertEquals(turtle.y, 50.0);
	}
}
