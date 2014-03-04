package command;

import controller.Controller;

public class CheckPenDownCommand extends ZeroParamCommand {

	@Override
	public double execute() {
		return Controller.getPenVisibility();
	}

}
