package commandcontrol;

import controller.TurtleController;

public class ClearScreenCommand extends ZeroParamCommands {

	@Override
	public double execute() {
		TurtleController.clearScreen();
		return TurtleController.setXY(0, 0);
	}

}
