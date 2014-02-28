package controller;
import model.*;

public class ExecutiveController {

	private Parser myParser;
	
	public ExecutiveController() {
		myParser = new Parser();
		
	}
	
	public void execute(String text) throws Exception {
		myParser.parseProgram(text);
	}
	
	
}
