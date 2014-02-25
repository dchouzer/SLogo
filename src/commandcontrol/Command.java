package commandcontrol;

import java.util.*;

public abstract class Command {
	
	private List<Command> mySubCommands;
	
	public Command (List<Command> l){
		mySubCommands = l;
	}
	
	public abstract void execute();
	
}
