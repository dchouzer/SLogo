package commandcontrol;

import java.util.List;

import controller.TurtleController;

public class RotateLeftCommand extends OneParamCommands{

	public RotateLeftCommand(Command c){
		super(c);
	}

	@Override
	public double execute() {
		myAmount = myInput.execute();
		return TurtleController.rotate(myAmount);
	}
	
}
