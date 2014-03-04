package model;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.List;

/**
 * @author David Chou
 * @author Kat Krieger
 * @author jerrysmooth
 */

public class Turtle {

	private double angle;
	private boolean isVisible;
	private double x, y;
	private Pen pen;

	public Turtle(double x, double y) {
		angle = 0;
		isVisible = true;
		this.x = x;
		this.y = y;
		pen = new Pen(x, y);
	}
	
	/*
	 * Allows the model to place the turtle at a particular position
	 */
	public double setXY(double x, double y) {
		double distanceMoved = Point.distance(this.x, this.y, x, y);
		this.x = x;
		this.y = y;
		pen.addPoint(x, y);
		return distanceMoved;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getAngle() {
		return angle;
	}
	
	public double setAngle(double angle) {
		this.angle = angle;
		return angle;
	}

	public double moveForward(double magnitude) {
		this.setXY(x + magnitude * (Math.cos(angle*Math.PI/180)), 
				y + magnitude * (Math.sin(angle*Math.PI/180)));
		return magnitude;
	}

	public double moveBackward(double magnitude) {
		this.moveForward(-1 * magnitude);
		return magnitude;
	}
	
	public double rotateLeft(double angleToRotate) {
		angle += angleToRotate;
		return angleToRotate;
	
	}

	public double rotateRight(double angleToRotate) {
		rotateLeft(-1 * angleToRotate);
		return angleToRotate;
	}
	
	//Throws the turtle back to original position
	public double reset() {
		return setXY(0, 0);
	}
	
	public int hideTurtle() {
		isVisible = false;
		return 0;
	}

	public int showTurtle() {
		isVisible = true;
		return 1;
	}
	
	public void undoMove() {
		this.x = pen.getHistory().get(pen.getHistory().size() - 2).getX(); 
		this.y = pen.getHistory().get(pen.getHistory().size() - 2).getY();
		pen.undoTrace();
	}
	
	public List<Point2D> getLocationHistory() {
		return pen.getHistory();
	}
	
	public Pen getPen() {
		return pen;
	}
}
