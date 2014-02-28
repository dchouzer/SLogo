package commandcontrol;

import controller.TurtleController;

public class ForwardCommand extends OneParamCommands {
	
	public ForwardCommand(Command c) {
		super(c);
	}
	
	public double execute(){
		myAmount = myInput.execute();
		return TurtleController.move(myAmount);
	}
}
