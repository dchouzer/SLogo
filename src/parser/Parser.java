package parser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import commandcontrol.*;

public class Parser {

	String stringToParse;
	String[] myStringArray;
	List<Command> myCommandList;
	int cursor;
//	Set<String> zeroParamSet;
//	Set<String> oneParamSet;
//	Set<String> twoParamSet;
	Map<String, Integer> numParamMap;
	Map<String, String> commandMap;
	
	public Parser() {
		numParamMap = new HashMap<String, Integer>();
		commandMap = new HashMap<String, String>();
//		zeroParamSet = new HashSet<String>();
//		oneParamSet = new HashSet<String>();
//		twoParamSet = new HashSet<String>();
		//TODO: fill in map of commands
		//One parameter commands
		numParamMap.put("fd", 1);
		numParamMap.put("forward", 1);
		numParamMap.put("back", 1);
		numParamMap.put("bk", 1);
		numParamMap.put("left", 1);
		numParamMap.put("lt", 1);
		numParamMap.put("right", 1);
		numParamMap.put("rt", 1);
		numParamMap.put("setheading", 1);
		numParamMap.put("seth", 1);
		numParamMap.put("random", 1);
		numParamMap.put("sin", 1);
		numParamMap.put("cos", 1);
		numParamMap.put("tan", 1);
		numParamMap.put("arctan", 1);
		numParamMap.put("log", 1);
		numParamMap.put("not", 1);
		
		//Zero parameter commands
		numParamMap.put("pendown", 0);
		numParamMap.put("pd", 0);
		numParamMap.put("penup", 0);
		numParamMap.put("pu", 0);
		numParamMap.put("showturtle", 0);
		numParamMap.put("st", 0);
		numParamMap.put("hideturtle", 0);
		numParamMap.put("ht", 0);
		numParamMap.put("home", 0);
		numParamMap.put("clearscreen", 0);
		numParamMap.put("cs", 0);
		numParamMap.put("xcor", 0);
		numParamMap.put("ycor", 0);
		numParamMap.put("heading", 0);
		numParamMap.put("pendown?", 0);
		numParamMap.put("pendownp", 0);
		numParamMap.put("showing?", 0);
		numParamMap.put("showingp", 0);
		
		//Two parameter commands
		numParamMap.put("sum", 2);
		numParamMap.put("+", 2);
		numParamMap.put("difference", 2);
		numParamMap.put("-", 2);
		numParamMap.put("product", 2);
		numParamMap.put("*", 2);
		numParamMap.put("quotient", 2);
		numParamMap.put("/", 2);
		numParamMap.put("remainder", 2);
		numParamMap.put("%", 2);
		numParamMap.put("minus", 2);
		numParamMap.put("~", 2);
		numParamMap.put("pow", 2);
		numParamMap.put("less?", 2);
		numParamMap.put("lessp", 2);
		numParamMap.put("greater?", 2);
		numParamMap.put("greaterp", 2);
		numParamMap.put("equal?", 2);
		numParamMap.put("equalp", 2);
		numParamMap.put("notequal?", 2);
		numParamMap.put("notequalp", 2);
		numParamMap.put("and", 2);
		numParamMap.put("or", 2);	
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
