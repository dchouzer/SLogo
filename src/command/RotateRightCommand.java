package command;

import java.util.List;

import controller.Controller;

public class RotateRightCommand extends OneParamCommand{

	public RotateRightCommand(Command c) {
		super(c);
	}

	@Override
	public double execute() {
		myAmount = myInput.execute();
		Controller.rotate(myAmount);
		return myAmount;
	}
	
}