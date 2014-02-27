package commandcontrol;

import controller.Controller;

public class BackCommand extends OneParamCommands {
	
	public BackCommand(Command c) {
		super(c);
	}
	
	public double execute(){
		myAmount = -(myInput.execute());
		return Controller.move(myAmount);
	}
}

