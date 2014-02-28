package commandcontrol;

import java.util.List;

import controller.TurtleController;

public class SetHeadingCommand extends OneParamCommands {

	public SetHeadingCommand(Command c) {
		super(c);
	}

	@Override
	public double execute() {
		myAmount = myInput.execute();
		return TurtleController.setHeading(myAmount);
	}

}
