package commandcontrol;

import controller.Controller;

public class PenDownCommand extends ZeroParamCommands {

	@Override
	public double execute() {
		return Controller.changePenVisibility(1);
	}

}
