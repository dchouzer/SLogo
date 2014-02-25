package commandcontrol;

import java.util.List;

public class ForwardCommand extends OneParamCommands {
	
	private int myAmount;
	
	public ForwardCommand(List<Command> l) {
		super(l);
	}
	
	public int execute(){
		//move turtle forward
		return myAmount;
	}
}
