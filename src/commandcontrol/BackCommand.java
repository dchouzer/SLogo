package commandcontrol;

import java.util.List;

public class BackCommand extends OneParamCommands {
	
	private int myAmount;
	
	public BackCommand(List<Command> l) {
		super(l);
	}
	
	public int execute(){
		//move turtle backward
		return myAmount;
	}
}

