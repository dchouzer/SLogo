package commandcontrol;

import controller.TurtleController;

public class HomeCommand extends ZeroParamCommands {

	@Override
	public double execute() {
		return TurtleController.setXY(0, 0);
	}

}
