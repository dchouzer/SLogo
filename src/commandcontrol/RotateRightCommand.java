package commandcontrol;

import java.util.List;

import controller.Controller;

public class RotateRightCommand extends OneParamCommands{

	public RotateRightCommand(Command c) {
		super(c);
	}

	@Override
	public double execute() {
		myAmount = myInput.execute();
		return Controller.rotate(myAmount);
	}
	
}