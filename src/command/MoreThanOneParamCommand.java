package command;

import java.util.*;

public abstract class MoreThanOneParamCommand implements Command{
	
	protected List<Command> mySubCommands;
	
	public MoreThanOneParamCommand(List<Command> l){
		mySubCommands = l;
	}
}
