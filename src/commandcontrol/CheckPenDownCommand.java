package commandcontrol;

import controller.TurtleController;

public class CheckPenDownCommand extends ZeroParamCommands {

	@Override
	public double execute() {
		return TurtleController.getPenVisibility();
	}

}
