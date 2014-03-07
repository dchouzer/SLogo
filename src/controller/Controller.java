package controller;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import program.Evaluator;
import program.Parser;
import viewer.AggregateViewer;
import viewer.TopLeftView;
import viewer.TurtleViewer;

/**
 * @author Richard Cao
 * @author jerrysmooth
 */

public class Controller extends JPanel {
	
	//private Map<Integer, Turtle> myTurtles;
	private Parser myParser;
	private AggregateViewer myCanvas;
	private JTabbedPane myTabbedPane;
	
	public Controller () {
		myParser = new Parser();
//		AggregateViewer myCanvas1 = new AggregateViewer(this);
		myCanvas = new AggregateViewer(this);
//		myTabbedPane = new JTabbedPane();
//		myTabbedPane.addTab("tab1", null, myCanvas1, "asdfs");
//		myTabbedPane.addTab("tab 2", null, myCanvas, "asldkjf");
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
	
	public void setPenColor(String color){
		System.out.println("set to "+ color);
		}
	
	public static double getPenColor(){
		return 0;
	}
	
	public static double setShape(double index){
		return index;
	}
	
	public static double getShape(){
		return 0;
	}
	
	public void setTurtleImage(String str){
		myCanvas.setTurtleImage(str);
	}

}
