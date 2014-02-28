package model;

import jgame.JGImage;
import jgame.JGObject;

public class Turtle extends JGObject{

	private double myAngle;
	private boolean isVisible;

	public Turtle(double x, double y, double speed) {
		super("turtle", true, x, y, 1, "turtle", 0, 0, speed, speed, -1);
		myAngle = 0.0;
		isVisible = true;
	}

	public void moveForward(double magnitude) {
		
	}

	public void moveBackward(double magnitude) {
		
	}
	
	public void rotateLeft(double angleToRotate) {
		myAngle += angleToRotate;
		
	}

	public void rotateRight(double angleToRotate) {
		myAngle -= angleToRotate;
	}
	
	//Throws the turtle back to original position
	public void reset() {
		x = 0;
		y = 0;
	}
	
	public void hideTurtle() {
		
	}

	public void showTurtle() {

	}

	public void remove() {
		
	}
}
