package commandcontrol;

import controller.TurtleController;

public class PenDownCommand extends ZeroParamCommands {

	@Override
	public double execute() {
		return TurtleController.changePenVisibility(1);
	}

}
