package commandcontrol;

import controller.TurtleController;

public class YCorCommand extends ZeroParamCommands {

	@Override
	public double execute() {
		return TurtleController.ycor();
	}

}
