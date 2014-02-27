package commandcontrol;

import controller.Controller;

public class HideTurtleCommand extends ZeroParamCommands {

	@Override
	public double execute() {
		return Controller.changeTurtleVisibility(1);
	}

}
