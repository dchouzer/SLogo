package commandcontrol;

import controller.TurtleController;

public class HeadingCommand extends ZeroParamCommands {
	
	@Override
	public double execute() {
		return TurtleController.getHeading();
	}

}
