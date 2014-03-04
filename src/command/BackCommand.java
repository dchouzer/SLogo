package command;

import controller.Controller;

public class BackCommand extends OneParamCommand {
	
	public BackCommand(Command c) {
		super(c);
	}
	
	public double execute(){
		myAmount = -(myInput.execute());
		Controller.move(myAmount);
		return myAmount;
	}
}

