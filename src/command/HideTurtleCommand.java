package command;

import controller.Controller;

public class HideTurtleCommand extends ZeroParamCommand {

	@Override
	public double execute() {
		return Controller.changeTurtleVisibility(1);
	}

}
