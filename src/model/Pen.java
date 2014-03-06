package model;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

/**
 * @author David Chou
 * @author jerrysmooth
 */

public class Pen {

	private boolean isVisible;
	private List<Point2D> pointHistory;
	
	public Pen(int initialX, int initialY) {
		isVisible = true;
		pointHistory = new ArrayList<Point2D>();
		this.addPoint(initialX, initialY);
	}
	
	public Pen(double initialX, double initialY) {
		this((int) initialX, (int) initialY);
	}

	public int turnPenOff() {
		isVisible = false;
		return 0;
	}
	
	public int turnPenOn() {
		isVisible = true;
		return 1;
	}
	
	public boolean isPenDrawing() {
		return isVisible;
	}
	
	public void addPoint(int x, int y) {
		this.addPoint(new Point(x ,y));
	}
	
	public void addPoint(double x, double y) {
		this.addPoint((int) x, (int) y);
	}
	
	public void addPoint(Point2D point) {
		pointHistory.add(point);
	}
	
	public void undoTrace() {
		try {
			pointHistory.remove(pointHistory.size() - 1);
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}
	
	public List<Point2D> getHistory() {
		return pointHistory;
	}
	
	// TO DO!!!!
	public void setColor(){
		
	}
}

