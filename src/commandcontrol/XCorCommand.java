package commandcontrol;

import controller.TurtleController;

public class XCorCommand extends ZeroParamCommands {

	@Override
	public double execute() {
		return TurtleController.xcor();
	}

}
