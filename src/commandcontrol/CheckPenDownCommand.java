package commandcontrol;

import controller.Controller;

public class CheckPenDownCommand extends ZeroParamCommands {

	@Override
	public double execute() {
		return Controller.getPenVisibility();
	}

}
