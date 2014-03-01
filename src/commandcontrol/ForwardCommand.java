package commandcontrol;

import controller.Controller;

public class ForwardCommand extends OneParamCommands {
	
	public ForwardCommand(Command c) {
		super(c);
	}
	
	public double execute(){
		myAmount = myInput.execute();
		return Controller.move(myAmount);
	}
}
