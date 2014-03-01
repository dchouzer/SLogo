package controller;
import model.*;

/*
 * @author David Chou
 */

public class ExecutiveController {

	private Parser myParser;
	
	public ExecutiveController() {
		myParser = new Parser();
		
	}
	
	public void execute(String text) throws Exception {
		myParser.parseProgram(text);
	}
	
	
}
