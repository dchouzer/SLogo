package controller;

import program.Evaluator;
import program.Parser;
import viewer.TextViewerArea;
import viewer.TurtleViewer;

/**
 * @author Richard Cao
 * @author jerrysmooth
 */

public class Controller {
	
	//private Map<Integer, Turtle> myTurtles;
	private Parser myParser;
	private TextViewerArea myTextViewer;
	private TurtleViewer myTurtleViewer;
	
	public Controller (Parser parser, TextViewerArea textViewer, TurtleViewer turtleViewer) {
		myParser = parser;
		myTextViewer = textViewer;
		myTurtleViewer = turtleViewer;
	}
	
	public void execute(String program) throws Exception {
		(new Evaluator()).execute(myParser.parseProgram(program));
	}
	
	public static void move(double dist){
		return;
	}
	
	public static void rotate(double degrees){
		return;
	}
	
	public static double setHeading(double degrees){
		//return myViewer.setHeading()
		return 0.0;
	}
	
	public static double setXY(double x, double y){
		return 0.0;
	}
	
	public static double changePenVisibility(double status){
		return 0.0;
	}
	
	public static double changeTurtleVisibility(double status){
		return 0.0;
	}
	
	public static void clearScreen(){
		
	}
	
	public static double xcor(){
		return 0.0;
	}
	
	public static double ycor(){
		return 0.0;
	}
	
	public static double getHeading(){
		return 0.0;
	}
	
	public static double getPenVisibility(){
		return 0.0;
	}
	
	public static double getTurtleVisibility(){
		return 0.0;
	}

}
