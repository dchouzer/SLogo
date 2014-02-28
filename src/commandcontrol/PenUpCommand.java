package commandcontrol;

import controller.TurtleController;

public class PenUpCommand extends ZeroParamCommands {

	@Override
	public double execute() {
		return TurtleController.changePenVisibility(0);
	}

}
