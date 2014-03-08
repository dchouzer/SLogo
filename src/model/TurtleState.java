package model;

import java.awt.Color;

import controller.Controller;

public class TurtleState {
	
	
	private Controller myController;
	private Color color;
	private String TurtleImage;
	
	public TurtleState(Controller controller){
		myController = controller;
	}
	
	public void saveTurtleState(){
		TurtleImage = getCurrentTurtleImage();
		color = getPenColor();
	}
	
	public void loadTurtleState(){
		setPenColor(color);
		setTurtleImage(TurtleImage);
	}
	
	
	public void setPenColor(Color color){
		myController.setPenColor(color);
	}
	
	public void setTurtleImage(String str){
		myController.setTurtleImage(str);
	}
	
	public Color getPenColor(){
		return myController.getPenColor();
	}
	
	public String getCurrentTurtleImage(){
		return myController.getCurrentTurtleImage();
	}

}
