package commandcontrol;

import controller.TurtleController;

public class BackCommand extends OneParamCommands {
	
	public BackCommand(Command c) {
		super(c);
	}
	
	public double execute(){
		myAmount = -(myInput.execute());
		return TurtleController.move(myAmount);
	}
}

