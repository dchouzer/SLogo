package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import commandcontrol.Command;
import commandcontrol.NumberCommand;

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
		
		String packname = "commandcontrol";
		
		addCommandMapping(new String[] {"fd","forward"}, packname + ".ForwardCommand");
		addCommandMapping(new String[] {"bk","back"}, packname + ".BackCommand");
		addCommandMapping(new String[] {"lt","left"}, packname + ".RotateLeftCommand");
		addCommandMapping(new String[] {"rt","right"}, packname + ".RotateRightCommand");
		addCommandMapping(new String[] {"sum","+"},  packname +".SumCommand");
		addCommandMapping(new String[] {"repeat"},  packname +".LoopCommand");
	}
	
	
	
	public void parseProgram (String program) throws Exception {
		stringToParse = program.toLowerCase();
		myStringArray = stringToParse.split("\\s+");
		cursor = -1;
		myCommandList = parse(myStringArray);
	}
	
	/*This method should run through the  array
	 * to check what kind of command each box is -
	 * after it examines the type of command that
	 * is there, it should look at a number of corresponding
	 * values based on that type of command
	 */
	//Can use this to run through the string and store
	
	private Command recursiveParse(String[] commandStrings) throws Exception {	
		cursor++;
		
		if(cursor >= commandStrings.length) {
			return null;
		}
		
		String commandString = commandStrings[cursor];
		
		if(isNumber(commandString)) {
			return new NumberCommand(Double.parseDouble(commandStrings[cursor]));
		}
		
		if(numParams(commandString) == 0) {
			return (Command) Class.forName(commandMap.get(commandStrings[cursor])).getConstructor().newInstance();
		}
		
		if(numParams(commandString) == 1) {
			Command theCommand = recursiveParse(commandStrings);
			return (Command) Class.forName(commandMap.get(commandString)).getConstructor(Command.class).newInstance(theCommand);
		}
		
		if(numParams(commandString) == 2) {
			List<Command> commandList = new ArrayList<Command>();
			commandList.add(recursiveParse(commandStrings));
			commandList.add(recursiveParse(commandStrings));
			return (Command) Class.forName(commandMap.get(commandString)).getConstructor(List.class).newInstance(commandList);
		}
		
		if(isControlStructure(commandString)) {
			Command c = recursiveParse(commandStrings);
			cursor++;
			List<Command> commandBlock = parse(getControlBlock(commandStrings));
			cursor++; //advance to the closing bracket
			return (Command) Class.forName(commandMap.get(commandString)).
					getConstructor(Command.class, List.class).newInstance(c, commandBlock);
		}
		
		return null;
	}
	
	private List<Command> parse(String[] commandStrings) throws Exception {
		List<Command> commandList = new ArrayList<Command>();
		while(cursor <= commandStrings.length - 1) {
			Command c = recursiveParse(commandStrings);
			if(c != null)
				commandList.add(c);
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
		if(!numParamMap.containsKey(commandString)) {
			return -1;
		}
		return numParamMap.get(commandString);
	}
	
	private void addCommandMapping(String[] commandStrings, String value) {
		for(String s : commandStrings) {
			commandMap.put(s, value);
		}
	}
	
	private boolean isControlStructure(String commandString) {
		if(commandString == "repeat")
			return true;
		return false;
	}
	
	private String[] getControlBlock(String[] commandStrings) {
		Stack<String> stack = new Stack<String>();
		int i = cursor;
		for(String s : commandStrings) {
			if(s.equals("[")) {
				stack.push(s);
			}
			if(s.equals("]")) {
				if(!s.isEmpty()) {
					stack.pop();
					if(s.isEmpty()) {
						break;
					}
				} else {}
					//bracket mismatch error
			}
			i++;
		}
		
		return Arrays.copyOfRange(commandStrings, 0, i);
	}
	
}
