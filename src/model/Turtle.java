package model;

import java.awt.geom.Point2D;
import java.util.List;

/*
 * @author David Chou
 * @author Kat Krieger
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
	public void setXY(double x, double y) {
		this.x = x;
		this.y = y;
		pen.addPoint(x, y);
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
	
	public void setAngle(double angle) {
		this.angle = angle;
	}

	public void moveForward(double magnitude) {
		this.setXY(x + magnitude * (Math.cos(angle*Math.PI/180)), 
				y + magnitude * (Math.sin(angle*Math.PI/180)));
	}

	public void moveBackward(double magnitude) {
		this.moveForward(-1 * magnitude);
	}
	
	public void rotateLeft(double angleToRotate) {
		angle += angleToRotate;
	
	}

	public void rotateRight(double angleToRotate) {
		rotateLeft(-1 * angle);
	}
	
	//Throws the turtle back to original position
	public void reset() {
		setXY(0, 0);
	}
	
	public void hideTurtle() {
		isVisible = false;
	}

	public void showTurtle() {
		isVisible = true;
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
