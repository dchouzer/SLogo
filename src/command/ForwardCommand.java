package command;

import controller.Controller;

public class ForwardCommand extends OneParamCommand {
	
	public ForwardCommand(Command c) {
		super(c);
	}
	
	public double execute(){
		myAmount = myInput.execute();
		Controller.move(myAmount);
		return myAmount;
	}
}
