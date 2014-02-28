package commandcontrol;

import controller.TurtleController;

public class HideTurtleCommand extends ZeroParamCommands {

	@Override
	public double execute() {
		return TurtleController.changeTurtleVisibility(1);
	}

}
