package commandcontrol;

import java.util.*;

public abstract class MoreThanOneParamCommands implements Command{
	
	protected List<Command> mySubCommands;
	protected int amountToReturn;
	
	public MoreThanOneParamCommands(List<Command> l){
		mySubCommands = l;
	}
}
