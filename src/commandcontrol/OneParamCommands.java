package commandcontrol;

import java.util.*;

public abstract class OneParamCommands implements Command{
	
	protected Command myInput;
	protected double myAmount;
	
	public OneParamCommands(Command c){
		myInput = c;
	}
}
