package commandcontrol;

import java.util.*;

public abstract class OneParamCommands implements Command{
	
	protected List<Command> mySubCommands;
	protected int amountToReturn;
	
	public OneParamCommands(List<Command> l){
		mySubCommands = l;
	}
}
