package commandcontrol;

import java.util.List;

import controller.TurtleController;

public class RotateRightCommand extends OneParamCommands{

	public RotateRightCommand(Command c) {
		super(c);
	}

	@Override
	public double execute() {
		myAmount = myInput.execute();
		return TurtleController.rotate(myAmount);
	}
	
}