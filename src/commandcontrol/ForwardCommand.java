package commandcontrol;

import java.util.List;

public class ForwardCommand extends OneParamCommands {
	
	private double myAmount;
	
	public ForwardCommand(List<Command> l) {
		super(l);
	}
	
	public double execute(){
		//move turtle forward
		return myAmount;
	}
}
