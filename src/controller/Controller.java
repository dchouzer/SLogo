package controller;

import java.awt.Color;

import main.Evaluator;
import main.Parser;

import viewer.AggregateViewer;
import viewer.TopLeftView;
import viewer.TurtleViewer;
import viewer.ViewContainer;

/**
 * @author Richard Cao
 * @author jerrysmooth
 * @author katharinekrieger
 * @author David Chou
 */

public class Controller {
	
	//private Map<Integer, Turtle> myTurtles;
	private Parser myParser;
	private ViewContainer myCanvas;
	
	
	public Controller () {
		myParser = new Parser();
		myCanvas = new ViewContainer(this);
	}
	
	public void execute(String program) throws Exception {
		(new Evaluator()).execute(myParser.parseProgram(program));
		myCanvas.addCommandToList(program);
		
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
	
	public void setPenColor(String string){
		myCanvas.setPenColor(string);
	}
	
	public Color getPenColor(){
		return myCanvas.getPenColor();
	}
	
	public static double setShape(double index){
		return index;
	}
	
	public static double getShape(){
		return 0;
	}
	public String getCurrentTurtleImage(){
		return myCanvas.getCurrentTurtleImage();
	}
	
	public void setTurtleImage(String str){
		myCanvas.setTurtleImage(str);
	}
	
	public void saveCommandsToFile(){
		myCanvas.saveCommandsToFile();
	}

	public void loadCommandsToText() {
		myCanvas.loadCommandsToText();
		
	}
	
	public void addTab(){
		myCanvas.createTab();
	}
	public void removeTab(){
		myCanvas.removeTab();
	}
	
	public void saveWorkspace(){
		myCanvas.saveWorkspace();
	}
	
	public void loadWorkspace(){
		myCanvas.loadWorkspace();
	}
	
	public void undo() {
		// TODO Auto-generated method stub
		
	}

	public void redo() {
		// TODO Auto-generated method stub
		
	}

	public void setPenColor(Color color) {
		myCanvas.setPenColor(color);
		
	}

	public void setBackground(String string) {
		myCanvas.setBackground(string);
		
	}
}
