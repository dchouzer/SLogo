package controller;
import java.util.Map;

import viewer.Viewer;

import model.*;

/*
 * @author Richard Cao
 */

public class Controller {
	
	private Map<Integer, Turtle> myTurtles;
	private Parser myParser;
	private Viewer myViewer;
	
	public Controller () {
		myParser = new Parser();
		myViewer = new Viewer();
	}
	
	public void execute(String program) throws Exception {
		myParser.parseProgram(program);
	}
	
	public static void move(double dist){
		return;
	}
	
	public static void rotate(double degrees){
		return;
	}
	
	public static void setHeading(double degrees){
		return;
	}
	
	public static void setXY(double x, double y){
		return;
	}
	
	public static void changePenVisibility(double status){
		return;
	}
	
	public static void changeTurtleVisibility(double status){
		return;
	}
	
	public static void clearScreen(){
		
	}
	
	public static void xcor(){
		return;
	}
	
	public static void ycor(){
		return;
	}
	
	public static void getHeading(){
		return;
	}
	
	public static void getPenVisibility(){
		return;
	}
	
	public static void getTurtleVisibility(){
		return;
	}
	
	public static double sum(double num1, double num2){
		return num1 + num2;
	}
	
	public static double multiply(double num1, double num2){
		return num1 * num2;
	}
	
	public static double remainder(double num1, double num2){
		return num1 % num2;
	}
	
	public static double setNegativeNumbers(double expr){
		return -expr;
	}
	
	public static double random(double max){
		return Math.random() * max;
	}
	
	public static double sin(double degrees){
		return Math.sin(degrees);
	}
	
	public static double cos(double degrees){
		return Math.cos(degrees);
	}
	
	public static double tan(double degrees){
		return Math.tan(degrees);
	}
	
	public static double atan(double degrees){
		return Math.atan(degrees);
	}
	
	public static double log(double expr){
		return Math.log(expr);
	}
	
	public static double pow(double base, double exponent){
		return Math.pow(base, exponent);
	}

}
