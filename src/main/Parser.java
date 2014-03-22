package main;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Stack;

import command.Command;
import command.NumberCommand;

public class Parser {

	String stringToParse;
	String[] myStringArray;
	List<Command> myCommandList;
	int cursor;
	private Map<String, Integer> numParamMap;
	private Map<String, String> commandMap;
	
	private static final String COMMAND_PACKAGE = "command";
	
	public Parser() {
		numParamMap = new HashMap<String, Integer>();
		commandMap = new HashMap<String, String>();
		this.loadCommandMaps();
	}
	
	
	
	public List<Command> parseProgram (String program) throws Exception {
		stringToParse = program.toLowerCase();
		myStringArray = stringToParse.split("\\s+");
		cursor = -1;
		myCommandList = parse(myStringArray);
		return myCommandList;
	}
	
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
		
		if(numParams(commandString) == -1) {
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
			@SuppressWarnings("unused")
			double d = Double.parseDouble(s);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	private int numParams(String commandString) {
		if(!numParamMap.containsKey(commandString)) {
			return -10;
		}
		return numParamMap.get(commandString);
	}
	
	private String[] getControlBlock(String[] commandStrings) {
		Stack<String> stack = new Stack<String>();
		int i = 0;
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
		
		String[] theArray = Arrays.copyOfRange(commandStrings, 0, i - 1);
		
		return theArray;
	}
	
	private void loadCommandMaps() {
		Properties properties = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream inputStream = loader.getResourceAsStream("resources/commands_nums.properties");
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(String commandString : properties.stringPropertyNames()) {
			String commandName = COMMAND_PACKAGE + "." + properties.getProperty(commandString).split(",")[0].trim();
			int numParams = Integer.parseInt(properties.getProperty(commandString).split(",")[1].trim());
			commandMap.put(commandString, commandName);
			numParamMap.put(commandString, numParams);
		}
	}
	
}
