package model;

import jgame.JGImage;
import jgame.JGObject;

/*
 * @author David Chou
 * @author Kat Krieger
 */

public class Turtle extends JGObject{

	private double myAngle;
	private boolean isVisible;

	public Turtle(double x, double y, double speed, String str) {
		super("turtle", true, x, y, 1, str, 0, 0, speed, speed, -1);
		myAngle = 90.0;
		isVisible = true;
	}

	public void moveForward(double magnitude) {
		x += magnitude * (Math.cos(myAngle)*180);
		y += magnitude * (Math.sin(myAngle)*180);
	}

	public void moveBackward(double magnitude) {
		x -= magnitude * (Math.cos(myAngle)*180);
		y -= magnitude * (Math.sin(myAngle)*180);
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
		isVisible = false;
	}

	public void showTurtle() {
		isVisible = true;
	}

	public void remove() {
		
	}
}
