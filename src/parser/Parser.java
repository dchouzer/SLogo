package parser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import commandcontrol.*;

public class Parser {

	String stringToParse;
	String[] myStringArray;
	List<Command> myCommandList;
	int cursor;
	Map<String, Integer> numParamMap;
	Map<String, String> commandMap;
	
	public Parser() {
		numParamMap = new HashMap<String, Integer>();
		commandMap = new HashMap<String, String>();
		//TODO: fill in map of commands
	}
	
	
	
	public void parseProgram (String program) {
		stringToParse = program;
		myStringArray = stringToParse.split("\\s+");
		cursor = -1;
		myCommandList = parse(myStringArray);
	}
	
	/*This method should run through the array
	 * to check what kind of command each box is -
	 * after it examines the type of command that
	 * is there, it should look at a number of corresponding
	 * values based on that type of command
	 */
	//Can use this to run through the string and store
	
	private Command recursiveParse(String[] commandStrings) {
		Command command = null;
		
		cursor++;
		
		if(cursor >= commandStrings.length) {
			return null;
		}
		
		if(isNumber(commandStrings[cursor])) {
			command = new NumberCommand(Double.parseString(commandStrings[cursor]));
		}
		
		if(numParams(commandStrings[cursor]) == 0) {
			command = (Command) Class.forName(commandMap.get(commandStrings[cursor])).getConstructor().newInstance();
		}
		
		if(numParams(commandStrings[cursor]) == 1) {
			Command theCommand = recursiveParse(commandStrings);
			command = (Command) Class.forName(commandMap.get(commandStrings[cursor])).getConstructor(Command.class).newInstance(theCommand);
		}
		
		if(numParams(commandStrings[cursor]) == 2) {
			List<Command> commandList = new ArrayList<Command>();
			commandList.add(recursiveParse(commandStrings));
			commandList.add(recursiveParse(commandStrings));
			command = (Command) Class.forName(commandMap.get(commandStrings[cursor])).getConstructor(List.class).newInstance(commandList);
		}
		
		return command;
	}
	
	private List<Command> parse(String[] commandStrings) {
		List<Command> commandList = new ArrayList<Command>();
		while(cursor >= commandStrings.length) {
			commandList.add(recursiveParse(commandStrings));
		}
		return commandList;
	}
	
	private boolean isNumber(String s) {
		try {
			double d = Double.parseDouble(s);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	private int numParams(String commandString) {
		return numParamMap.get(commandString);
	}
	
}
