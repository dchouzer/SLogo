package model;

import pensupplements.*;

import java.util.ArrayList;
import java.util.List;
/*
 * @author David Chou
 */

public class Pen {

	private boolean isVisible;
	private double myAngle;
	private List<Location> myList;
	
	public Pen(double x, double y, double speed) {
//		super("turtle", true, x, y, 1, "turtle", 0, 0, speed, speed, -1);
		myAngle = 90.0;
		isVisible = true;
		myList = new ArrayList<Location>();
	}

	public void turnPenOff() {
		isVisible = false;
	}
	
	public void turnPenOn() {
		isVisible = true;
	}
	
	public void setXY(double x, double y) {
//		this.x = x;
//		this.y = y;
	}
}

