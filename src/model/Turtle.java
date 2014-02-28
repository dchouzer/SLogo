package model;

import jgame.JGObject;

public class Turtle extends JGObject {

	public double myAngle;

	public Turtle(double x, double y, double speed) {
		super("turtle", true, x, y, 1, "turtle", 0, 0, speed, speed, -1);
		myAngle = 0.0;
	}

	public void move() {
		
	}

	public void rotateLeft(double angleToRotate) {
		
	}

	public void rotateRight(double angleToRotate) {

	}
	//Throws the turtle back to original position
	public void reset() {

	}
	
	public void hideTurtle() {

	}

	public void showTurtle() {

	}

}
