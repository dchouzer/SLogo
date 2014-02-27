package commandcontrol;

import java.util.List;

public class BackCommand extends OneParamCommands {
	
	private double myAmount;
	
	public BackCommand(List<Command> l) {
		super(l);
	}
	
	public double execute(){
		//move turtle backward
		return myAmount;
	}
}

