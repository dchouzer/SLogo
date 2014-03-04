package command;

import java.util.*;

public abstract class OneParamCommand implements Command{
	
	protected Command myInput;
	protected double myAmount;
	
	public OneParamCommand(Command c){
		myInput = c;
	}
}
