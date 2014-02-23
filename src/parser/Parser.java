package parser;
import java.util.List;

import commandcontrol.*;

public class Parser {

	String stringToParse;
	String[] myStringArray;
	List<Command> myCommandList;
	
	public Parser() {
		
	}
	
	public void inputTextCommands (String text) {
		stringToParse = text;
		myStringArray = stringToParse.split(" ");
	}
	/*This method should run through the array
	 * to check what kind of command each box is -
	 * after it examines the type of command that
	 * is there, it should look at a number of corresponding
	 * values based on that type of command
	 */
	//Can use this to run through the string and store
	public void parseString() {
		
		
		
	}
	
}
