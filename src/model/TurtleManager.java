package model;

import java.util.HashMap;
import java.util.Map;

public class TurtleManager {
	private Map<Integer, Turtle> turtleMap;
	private int turtleId = 1;
	
	public TurtleManager() {
		turtleMap = new HashMap<Integer, Turtle>();
	}
	
	public int addTurtle() {
		int newId = turtleId;
		turtleMap.put(newId, new Turtle(0, 0));
		turtleId++;
		return newId;
	}
	
	public Turtle getTurtle(int id) {
		return turtleMap.get(id);
	}
}
