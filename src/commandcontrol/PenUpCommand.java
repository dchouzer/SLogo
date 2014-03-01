package commandcontrol;

import controller.Controller;

public class PenUpCommand extends ZeroParamCommands {

	@Override
	public double execute() {
		return Controller.changePenVisibility(0);
	}

}
